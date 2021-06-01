package com.e.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.e.myapplication.R
import kotlinx.android.synthetic.main.activity_main3.*


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val rdg1 = findViewById<RadioGroup>(R.id.radiog1)
        //値を統一した
        var rg1 = 0
//        val rb1 = files
        rdg1.setOnCheckedChangeListener { group, checkedId ->
            val radio = findViewById<RadioButton>(checkedId)

            if (radioButton1.isChecked == true) {
                rg1 = 11
            } else if (radioButton2.isChecked == true) {
                rg1 = 5
            } else if (radioButton3.isChecked == true) {
                rg1 = 1
            }

        }

        val rdg2 = findViewById<RadioGroup>(R.id.radiog2)
        var rg2 = 0
        rdg2.setOnCheckedChangeListener { group, checkedId ->
            val radio = findViewById<RadioButton>(checkedId)

            if (radioButton4.isChecked == true) {
                rg2 = 12
            } else if (radioButton5.isChecked == true) {
                rg2 = 5
            } else if (radioButton6.isChecked == true) {
                rg2 = 1
            }

        }

        val rdg3 = findViewById<RadioGroup>(R.id.radiog3)
        var rg3 = 0
        rdg3.setOnCheckedChangeListener { group, checkedId ->
            val radio = findViewById<RadioButton>(checkedId)

            if (radioButton7.isChecked == true) {
                rg3 = 13
            } else if (radioButton8.isChecked == true) {
                rg3 = 5
            } else if (radioButton9.isChecked == true) {
                rg3 = 1
            }

        }

        val rdg4 = findViewById<RadioGroup>(R.id.radiog4)
        var rg4 = 0
        rdg4.setOnCheckedChangeListener { group, checkedId ->
            val radio = findViewById<RadioButton>(checkedId)

            if (radioButton10.isChecked == true) {
                rg4 = 14
            } else if (radioButton11.isChecked == true) {
                rg4 = 5
            } else if (radioButton12.isChecked == true) {
                rg4 = 1
            }

        }

        val rdg5 = findViewById<RadioGroup>(R.id.radiog5)
        var rg5 = 0
        rdg5.setOnCheckedChangeListener { group, checkedId ->
            val radio = findViewById<RadioButton>(checkedId)

            if (radioButton13.isChecked == true) {
                rg5 = 15
            } else if (radioButton14.isChecked == true) {
                rg5 = 5
            } else if (radioButton15.isChecked == true) {
                rg5 = 1
            }

        }

        val rdg6 = findViewById<RadioGroup>(R.id.radiog6)
        var rg6 = 0
        rdg6.setOnCheckedChangeListener { group, checkedId ->
            val radio = findViewById<RadioButton>(checkedId)

            if (radioButton16.isChecked == true) {
                rg6 = 16
            } else if (radioButton17.isChecked == true) {
                rg6 = 5
            } else if (radioButton18.isChecked == true) {
                rg6 = 1
            }

        }

        val rdg7 = findViewById<RadioGroup>(R.id.radiog7)
        var rg7 = 0
//        val rb7 = files
        rdg7.setOnCheckedChangeListener { group, checkedId ->
            val radio = findViewById<RadioButton>(checkedId)

            if (radioButton19.isChecked == true) {
                rg7 = 17
            } else if (radioButton20.isChecked == true) {
                rg7 = 5
            } else if (radioButton21.isChecked == true) {
                rg7 = 1
            }

        }
        button.setOnClickListener(View.OnClickListener {
            val rg = rg1 + rg2 + rg3 + rg4 + rg5 + rg6 + rg7
            val textView = findViewById<TextView>(R.id.textView11)
            //if文->whenに変更
            var text = ""
            when (rg) {

                in 0..6 ->  textView.text = "どれか１つ選んでください！"
                in 7..24 -> text = "その他"
                in 25..30 -> text = "ゲーム"
                in 31..36 -> text = "乗り物系"
                in 37..42 -> text = "美容健康系"
                in 43..48 -> text = "育成系"
                in 49..54 -> text = "つくる系"
                in 55..61 -> text = "観賞系"
                in 62..67 -> text = "音楽系"
                in 68..73 -> text = "思考系"
                in 74..79 -> text = "スキル、一芸系"
                in 80..85 -> text = "スポーツ系"
                in 86..91 -> text = "旅行お出かけ系"
                in 92..97 -> text = "飲食系"
                in 98..103 -> text = "自然アウトドア系"

                else -> textView.text = "エラー"
            }
            //val textView = findViewById<TextView>(R.id.textView14)

            if(text==""){

            }else {
                val intent = Intent(this, MainActivity4::class.java)
                //textは受け渡す変数
                //val text = rg1 + "," + rg2 + "," + rg3 + "," + rg4 + "," + rg5 + "," + rg6
                //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
                intent.putExtra("TEXT_KEY2", text)
                //画面遷移を開始
                startActivity(intent)
            }

        })
    }
}