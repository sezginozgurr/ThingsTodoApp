package com.example.thingstodoapp.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.thingstodoapp.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
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
            // This method will be executed once the timer is over
            // Start your app main activity
            startActivity(Intent(this, LoginPage::class.java))

            // close this activity
            finish()
        }, 2000)

    }
}