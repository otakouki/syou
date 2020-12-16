package com.e.myapplication

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.concurrent.thread


data class JoJo(val id: String, val name: String, val classname: String)


interface JoJoService {
//    -------レスポンスの中身-------
//    {
//        "name":"Jyotaro",
//        "stand":"The World"
//    }
//    -------おわり-----------

    @GET("api.php")
    fun fetchJoJo(@Query("id") id: String): Call<List<JoJo>>
}
fun pi(i: String, n: ImageView) {
    val temp =Picasso.get()
        //いらすとやの画像URL
        .load(i)
        .resize(300, 300) //表示サイズ指定
        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
        .into(n)
    return temp

}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit = Retrofit.Builder()
            .baseUrl("http://syou.sakura.ne.jp/")
            .addConverterFactory(GsonConverterFactory.create())
//           ↑↑↑↑↑↑↑↑
//             Gsonのファクトリーメソッド必須！

//            これがないと次のようなエラーが出てハマる
//            java.lang.IllegalArgumentException: Unable to create converter for class com.apppppp.retrofitsample.JoJo
//            for method JoJoService.fetchJoJo
//
            .build()


        val handler = Handler()

        thread { // Retrofitはメインスレッドで処理できない
            try {
                val service: JoJoService = retrofit.create(JoJoService::class.java)
                val jojo = service.fetchJoJo(id = "8").execute().body()
                    ?: throw IllegalStateException("bodyがnullだよ！")
                var len: Int = jojo.size


                handler.post(Runnable {
                    // メインスレッドで処理
//                        val nameTextView = findViewById<TextView>(R.id.name)
//                        val standTextView = findViewById<TextView>(R.id.stand)


                    Picasso.get()
                        //いらすとやの画像URL
                        .load(jojo[0].classname)
                        .resize(300, 300) //表示サイズ指定
                        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                        .into(imageView3) //imageViewに流し込み


                     //imageViewに流し込み
                    pi(jojo[0].classname,imageView5)

                    //standTextView.text = jojo[0].classname
                })


            } catch (e: Exception) {
                Log.d("mopi", "debug $e")
            }
        }

        //    }

    }
}