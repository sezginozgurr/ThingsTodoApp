package com.example.thingstodoapp.ui

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.thingstodoapp.R
import com.example.thingstodoapp.util.extStartActivity
import kotlinx.android.synthetic.main.fragment_login.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        logo.animate().apply {
            duration = 1000
            rotationYBy(360f)
        }.withEndAction {
            logo.animate().apply {
                duration = 1000
                rotationYBy(0f)
            }.start()
        }
        Handler().postDelayed({
            this@SplashActivity extStartActivity MainActivity::class.java
        }, 2000)
    }
}