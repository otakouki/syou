package com.e.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val text = intent.getStringExtra("TEXT_KEY2")
        text1.setText("あなたにおすすめの趣味は、${text.toString()}です。")
        button4.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            //画面遷移を開始
            startActivity(intent)
        })
    }
}