package com.e.myapplication

import android.media.audiofx.AudioEffect
import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.concurrent.thread

//データクラス定義
data class JoJo2(val GenreNo: String="", val TypeID: String="", val ID: String="", val Name: String="", val Description: String="",val CommunityLink: String="",val img: String="")


interface JoJoService2 {

    @GET("api2.php")
//    fun fetchJoJo(@Query("id") id: String): Call<List<JoJo>>
    fun fetchJoJo(@Query("GenreNo") GenreNo: String): Call<List<JoJo2>>
}

//画像処理　一旦放置
//fun pi(i: String, n: ImageView) {
//    val temp =Picasso.get()
//        //いらすとやの画像URL
//        .load(i)
//        .resize(300, 300) //表示サイズ指定
//        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
//        .into(n)
//    return temp
//
//}

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //LinearLayoutのlayoutを生成。
        val layout = findViewById<LinearLayout>(R.id.linear)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://syou.sakura.ne.jp/")//URL指定
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
                val text = intent.getStringExtra("TEXT_KEY")
                val no:String = text.toString()
                val service: JoJoService2 = retrofit.create(JoJoService2::class.java)
                val jojo = service.fetchJoJo(GenreNo = no).execute().body()//とりあえずGenreNo=6（鑑賞ジャンル）で投げている
                    ?: throw IllegalStateException("bodyがnullだよ！")
                
                //データが何個あるか数える
                var len: Int = jojo.size

                handler.post(Runnable {
                    //データ分ループして表示する"
                    //動的にtextviewを追加していく
                    for (i in 0..len-1) {
                        //趣味の名前表示
                        val textView: TextView= TextView(this)
                        var Namedata=jojo[i].Name
                        textView.text = Namedata
                        layout.addView(textView)

                        //趣味の説明表示
                        val DesctextView: TextView= TextView(this)
                        var Descdata=jojo[i].Description
                        DesctextView.text = Descdata
                        layout.addView(DesctextView)

                    }

                    })


            } catch (e: Exception) {
                Log.d("mopi", "debug $e")
            }
        }

    }
}