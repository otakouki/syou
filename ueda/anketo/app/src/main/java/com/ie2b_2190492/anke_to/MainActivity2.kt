package com.ie2b_2190492.anke_to

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ie2b_2190492.anke_to.R
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val text = intent.getStringExtra("TEXT_KEY2")
        text1.setText("${text.toString()}")
    }
}