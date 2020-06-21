package com.anant.codingguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {


    lateinit var btnNext:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        btnNext=findViewById(R.id.btnNext)

        btnNext.setOnClickListener {
            startActivity(Intent(this@WelcomeActivity, ControlActivity::class.java))
        }


    }
}