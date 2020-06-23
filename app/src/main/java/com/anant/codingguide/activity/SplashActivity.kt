package com.anant.codingguide.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.anant.codingguide.R

class SplashActivity : AppCompatActivity() {
            private val SPLASH_TIME_OUT:Long = 2000
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_splash)
                Handler().postDelayed({
                    startActivity(
                            Intent(this,
                                    WelcomeActivity::class.java)
                    )
                    finish()
                }, SPLASH_TIME_OUT)
            }
    }

