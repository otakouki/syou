package com.e.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val rdg1 = findViewById<RadioGroup>(R.id.radiog1)
        var rg1 = ""
//        val rb1 = files
        rdg1.setOnCheckedChangeListener { group, checkedId ->
            val radio = findViewById<RadioButton>(checkedId)

            if(radioButton1.isChecked == true){
                rg1 = "A"
            }else if(radioButton2.isChecked == true){
                rg1 = "B"
            }else if(radioButton3.isChecked == true){
                rg1 = "C"
            }

            }

        val rdg2 = findViewById<RadioGroup>(R.id.radiog2)
        var rg2 = ""
        rdg2.setOnCheckedChangeListener { group, checkedId ->
            val radio = findViewById<RadioButton>(checkedId)

            if(radioButton4.isChecked == true){
                rg2 = "A"
            }else if(radioButton5.isChecked == true){
                rg2 = "B"
            }else if(radioButton6.isChecked == true){
                rg2 = "C"
            }

        }

        val rdg3 = findViewById<RadioGroup>(R.id.radiog3)
        var rg3 = ""
        rdg3.setOnCheckedChangeListener { group, checkedId ->
            val radio = findViewById<RadioButton>(checkedId)

            if(radioButton7.isChecked == true){
                rg3 = "A"
            }else if(radioButton8.isChecked == true){
                rg3 = "B"
            }else if(radioButton9.isChecked == true){
                rg3 = "C"
            }

        }

        val rdg4 = findViewById<RadioGroup>(R.id.radiog4)
        var rg4 = ""
        rdg4.setOnCheckedChangeListener { group, checkedId ->
            val radio = findViewById<RadioButton>(checkedId)

            if(radioButton10.isChecked == true){
                rg4 = "A"
            }else if(radioButton11.isChecked == true){
                rg4 = "B"
            }else if(radioButton12.isChecked == true){
                rg4 = "C"
            }

        }

        val rdg5 = findViewById<RadioGroup>(R.id.radiog5)
        var rg5 = ""
        rdg5.setOnCheckedChangeListener { group, checkedId ->
            val radio = findViewById<RadioButton>(checkedId)

            if(radioButton13.isChecked == true){
                rg5 = "A"
            }else if(radioButton14.isChecked == true){
                rg5 = "B"
            }else if(radioButton15.isChecked == true){
                rg5 = "C"
            }

        }

        val rdg6 = findViewById<RadioGroup>(R.id.radiog6)
        var rg6 = ""
        rdg6.setOnCheckedChangeListener { group, checkedId ->
            val radio = findViewById<RadioButton>(checkedId)

            if(radioButton16.isChecked == true){
                rg6 = "A"
            }else if(radioButton17.isChecked == true){
                rg6 = "B"
            }else if(radioButton18.isChecked == true){
                rg6 = "C"
            }

        }



        button.setOnClickListener(View.OnClickListener {
//            val text = rda1 + rda2 + rda3 + rda4 + rda5 + rda6 + rda7 + rda8 + rda8 + rda10 + rda11 + rda12 + rda13 + rda14 + rda15 + rda16 + rda17 + rda18
            val textView = findViewById<TextView>(R.id.textView7)
        if(rg1 == ""  || rg2 == "" || rg3 == "" || rg4 == "" || rg5 == "" || rg6 ==""){
            textView.text = "どれか１つ選んでください！"
        }else {
//            val textView = findViewById<TextView>(R.id.textView7)
            val intent = Intent(this, MainActivity4::class.java)
            //textは受け渡す変数
            val text = rg1 + rg2 + rg3 + rg4 + rg5 + rg6
            //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
            intent.putExtra("TEXT_KEY2",text)
            //画面遷移を開始
            startActivity(intent)
        }
        })
    }
}