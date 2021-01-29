package com.e.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.View.OnLongClickListener
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.AppLaunchChecker
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*
import kotlin.concurrent.thread


data class JoJo(
    val GenreNo: String="",
    val GenreName: String="",
    val Questionnaire: String="",
    val AgeBetween_MIN: String="",
    val AgeBetween_MAX: String="",
    val img:String="")

interface JoJoService {
//    -------レスポンスの中身-------
//    {
//        "name":"Jyotaro",
//        "stand":"The World"
//    }
//    -------おわり-----------

    @GET("api3.php")
    fun fetchJoJo(): Call<List<JoJo>>
}



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // "DataStore"という名前でインスタンスを生成
        val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)
        if (AppLaunchChecker.hasStartedFromLauncher(this)) {



        } else {
//            textView8.text = "はじめてアプリを起動した"
            //生成したインスタンスを使って書き込む
            val editor = dataStore.edit()
            //”Check”にTrueを書き込む
            editor.putBoolean("Check",true)

            //UUIDを使ってランダム文字列生成、書き込み
            val uuidString = UUID.randomUUID().toString()
            editor.putString("UUID",uuidString)

            //コミットして処理終了
            editor.apply()
            //第2引数はデータが取得できなかったときに使用する値
            dataStore.getBoolean("Check",false)
//            textView8.text = uuidString
        }
        AppLaunchChecker.onActivityCreate(this)


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
                val jojo = service.fetchJoJo().execute().body()
                    ?: throw IllegalStateException("bodyがnullだよ！")
                var len: Int = jojo.size


                handler.post(Runnable {
                    // メインスレッドで処理
//                        val nameTextView = findViewById<TextView>(R.id.name)
//                        val standTextView = findViewById<TextView>(R.id.stand)

                    Picasso.get()
                        //いらすとやの画像URL
                        .load("http://" + jojo[0].img)
                        .resize(300, 300) //表示サイズ指定
                        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                        .into(image1) //ImageButtonに流し込み
                    Picasso.get()
                        //いらすとやの画像URL
                        .load("http://" + jojo[1].img)
                        .resize(300, 300) //表示サイズ指定
                        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                        .into(image2) //ImageButtonに流し込み

                    Picasso.get()
                        //いらすとやの画像URL
                        .load("http://" + jojo[2].img)
                        .resize(300, 300) //表示サイズ指定
                        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                        .into(image3) //ImageButtonに流し込み

                    Picasso.get()
                        //いらすとやの画像URL
                        .load("http://" + jojo[3].img)
                        .resize(300, 300) //表示サイズ指定
                        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                        .into(image4) //ImageButtonに流し込み
                    Picasso.get()
                        //いらすとやの画像URL
                        .load("http://" + jojo[4].img)
                        .resize(300, 300) //表示サイズ指定
                        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                        .into(image5) //ImageButtonに流し込み

                    Picasso.get()
                        //いらすとやの画像URL
                        .load("http://" + jojo[5].img)
                        .resize(300, 300) //表示サイズ指定
                        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                        .into(image6) //ImageButtonに流し込み
                    Picasso.get()
                        //いらすとやの画像URL
                        .load("http://" + jojo[6].img)
                        .resize(300, 300) //表示サイズ指定
                        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                        .into(image7) //ImageButtonに流し込み
                    Picasso.get()
                        //いらすとやの画像URL
                        .load("http://" + jojo[7].img)
                        .resize(300, 300) //表示サイズ指定
                        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                        .into(image8) //ImageButtonに流し込み
                    Picasso.get()
                        //いらすとやの画像URL
                        .load("http://" + jojo[8].img)
                        .resize(300, 300) //表示サイズ指定
                        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                        .into(image9) //ImageButtonに流し込み
                    Picasso.get()
                        //いらすとやの画像URL
                        .load("http://" + jojo[9].img)
                        .resize(300, 300) //表示サイズ指定
                        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                        .into(image10) //ImageButtonに流し込み
                    Picasso.get()
                        //いらすとやの画像URL
                        .load("http://" + jojo[10].img)
                        .resize(300, 300) //表示サイズ指定
                        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                        .into(image11) //ImageButtonに流し込み

                    Picasso.get()
                        //いらすとやの画像URL
                        .load("http://" + jojo[11].img)
                        .resize(300, 300) //表示サイズ指定
                        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                        .into(image12) //ImageButtonに流し込み
                    Picasso.get()
                        //いらすとやの画像URL
                        .load("http://" + jojo[12].img)
                        .resize(300, 300) //表示サイズ指定
                        .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                        .into(image13) //ImageButtonに流し込み
                    var gno = ""
                    val image1: ImageButton = findViewById(R.id.image1)
                        image1.setOnClickListener(View.OnClickListener() {
//                            Toast.makeText(applicationContext, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, MainActivity2::class.java)
                            //textは受け渡す変数
                            gno = "1"
                            //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
                            intent.putExtra("TEXT_KEY",gno)
                            //画面遷移を開始
                            startActivity(intent)

                        })

                    val image2: ImageButton = findViewById(R.id.image2)
                    image2.setOnClickListener(View.OnClickListener() {
//                            Toast.makeText(applicationContext, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity2::class.java)
                        //textは受け渡す変数
                        gno = "2"
                        //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
                        intent.putExtra("TEXT_KEY",gno)
                        //画面遷移を開始
                        startActivity(intent)

                    })
                    val image3: ImageButton = findViewById(R.id.image3)
                    image3.setOnClickListener(View.OnClickListener() {
//                            Toast.makeText(applicationContext, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity2::class.java)
                        //textは受け渡す変数
                        gno = "3"
                        //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
                        intent.putExtra("TEXT_KEY",gno)
                        //画面遷移を開始
                        startActivity(intent)

                    })

                    val image4: ImageButton = findViewById(R.id.image4)
                    image4.setOnClickListener(View.OnClickListener() {
//                            Toast.makeText(applicationContext, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity2::class.java)
                        //textは受け渡す変数
                        gno = "4"
                        //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
                        intent.putExtra("TEXT_KEY",gno)
                        //画面遷移を開始
                        startActivity(intent)

                    })

                    val image5: ImageButton = findViewById(R.id.image5)
                    image5.setOnClickListener(View.OnClickListener() {
//                            Toast.makeText(applicationContext, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity2::class.java)
                        //textは受け渡す変数
                        gno = "5"
                        //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
                        intent.putExtra("TEXT_KEY",gno)
                        //画面遷移を開始
                        startActivity(intent)

                    })

                    val image6: ImageButton = findViewById(R.id.image6)
                    image6.setOnClickListener(View.OnClickListener() {
//                            Toast.makeText(applicationContext, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity2::class.java)
                        //textは受け渡す変数
                        gno = "6"
                        //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
                        intent.putExtra("TEXT_KEY",gno)
                        //画面遷移を開始
                        startActivity(intent)

                    })

                    val image7: ImageButton = findViewById(R.id.image7)
                    image7.setOnClickListener(View.OnClickListener() {
//                            Toast.makeText(applicationContext, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity2::class.java)
                        //textは受け渡す変数
                        gno = "7"
                        //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
                        intent.putExtra("TEXT_KEY",gno)
                        //画面遷移を開始
                        startActivity(intent)

                    })

                    val image8: ImageButton = findViewById(R.id.image8)
                    image8.setOnClickListener(View.OnClickListener() {
//                            Toast.makeText(applicationContext, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity2::class.java)
                        //textは受け渡す変数
                        gno = "8"
                        //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
                        intent.putExtra("TEXT_KEY",gno)
                        //画面遷移を開始
                        startActivity(intent)

                    })

                    val image9: ImageButton = findViewById(R.id.image9)
                    image9.setOnClickListener(View.OnClickListener() {
//                            Toast.makeText(applicationContext, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity2::class.java)
                        //textは受け渡す変数
                        gno = "9"
                        //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
                        intent.putExtra("TEXT_KEY",gno)
                        //画面遷移を開始
                        startActivity(intent)

                    })

                    val image10: ImageButton = findViewById(R.id.image10)
                    image10.setOnClickListener(View.OnClickListener() {
//                            Toast.makeText(applicationContext, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity2::class.java)
                        //textは受け渡す変数
                        gno = "10"
                        //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
                        intent.putExtra("TEXT_KEY",gno)
                        //画面遷移を開始
                        startActivity(intent)

                    })

                    val image11: ImageButton = findViewById(R.id.image11)
                    image11.setOnClickListener(View.OnClickListener() {
//                            Toast.makeText(applicationContext, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity2::class.java)
                        //textは受け渡す変数
                        gno = "11"
                        //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
                        intent.putExtra("TEXT_KEY",gno)
                        //画面遷移を開始
                        startActivity(intent)

                    })

                    val image12: ImageButton = findViewById(R.id.image12)
                    image12.setOnClickListener(View.OnClickListener() {
//                            Toast.makeText(applicationContext, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity2::class.java)
                        //textは受け渡す変数
                        gno = "12"
                        //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
                        intent.putExtra("TEXT_KEY",gno)
                        //画面遷移を開始
                        startActivity(intent)

                    })

                    val image13: ImageButton = findViewById(R.id.image13)
                    image13.setOnClickListener(View.OnClickListener() {
//                            Toast.makeText(applicationContext, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity2::class.java)
                        //textは受け渡す変数
                        gno = "13"
                        //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
                        intent.putExtra("TEXT_KEY",gno)
                        //画面遷移を開始
                        startActivity(intent)

                    })

                    var flag1 = true
                    var flag2 = true
                    var flag3 = true
                    var flag4 = true
                    var flag5 = true
                    var flag6 = true
                    var flag7 = true
                    var flag8 = true
                    var flag9 = true
                    var flag10 = true
                    var flag11 = true
                    var flag12 = true
                    var flag13 = true
                        image1.setOnLongClickListener { // 下側のImageViewのidをimageViewとした例
                        if(flag1 == true) {
                            // この中にボタンが長押しされた時の処理を記述する
//                            image1.setImageResource(R.drawable.game)


                            Picasso.get()
                                //いらすとやの画像URL
                                .load(R.drawable.game)
                                .resize(300, 300) //表示サイズ指定
                                .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                                .into(image1) //ImageButtonに流し込み
                            flag1 = false


                        }else{
                            Picasso.get()
                                //いらすとやの画像URL
                                .load("http://" + jojo[0].img)
                                .resize(300, 300) //表示サイズ指定
                                .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                                .into(image1) //ImageButtonに流し込み
                            flag1 = true
                        }
                        true
                    }


                    image2.setOnLongClickListener { // 下側のImageViewのidをimageViewとした例
                        if(flag2 == true) {
                            // この中にボタンが長押しされた時の処理を記述する
//                            image1.setImageResource(R.drawable.game)
                            Picasso.get()
                                //いらすとやの画像URL
                                .load(R.drawable.skil)
                                .resize(300, 300) //表示サイズ指定
                                .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                                .into(image2) //ImageButtonに流し込み
                            flag2 = false
                        }else{
                            Picasso.get()
                                //いらすとやの画像URL
                                .load("http://" + jojo[1].img)
                                .resize(300, 300) //表示サイズ指定
                                .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                                .into(image2) //ImageButtonに流し込み
                            flag2 = true
                        }
                        true
                    }

                    image3.setOnLongClickListener { // 下側のImageViewのidをimageViewとした例
                        if(flag3 == true) {
                            // この中にボタンが長押しされた時の処理を記述する
//                            image1.setImageResource(R.drawable.game)
                            Picasso.get()
                                //いらすとやの画像URL
                                .load(R.drawable.sports)
                                .resize(300, 300) //表示サイズ指定
                                .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                                .into(image3) //ImageButtonに流し込み
                            flag3 = false
                        }else{
                            Picasso.get()
                                //いらすとやの画像URL
                                .load("http://" + jojo[2].img)
                                .resize(300, 300) //表示サイズ指定
                                .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                                .into(image3) //ImageButtonに流し込み
                            flag3 = true
                        }
                        true
                    }

                    image4.setOnLongClickListener { // 下側のImageViewのidをimageViewとした例
                        if(flag4 == true) {
                            // この中にボタンが長押しされた時の処理を記述する
//                            image1.setImageResource(R.drawable.game)
                            Picasso.get()
                                //いらすとやの画像URL
                                .load(R.drawable.nurturing)
                                .resize(300, 300) //表示サイズ指定
                                .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                                .into(image4) //ImageButtonに流し込み
                            flag4 = false
                        }else{
                            Picasso.get()
                                //いらすとやの画像URL
                                .load("http://" + jojo[3].img)
                                .resize(300, 300) //表示サイズ指定
                                .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
                                .into(image4) //ImageButtonに流し込み
                            flag4 = true
                        }
                        true
                    }




                })

                button2.setOnClickListener(View.OnClickListener {
                    val intent = Intent(this, MainActivity3::class.java)
                    startActivity(intent)
                })

                button1.setOnClickListener(View.OnClickListener {
                    val intent = Intent(this,MainActivity5::class.java)
                    startActivity(intent)
                })


            } catch (e: Exception) {
                Log.d("mopi", "debug $e")
            }
        }

        //    }

    }
}