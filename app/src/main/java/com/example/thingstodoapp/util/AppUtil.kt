package com.example.thingstodoapp.util

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.thingstodoapp.ui.MainActivity


infix fun <T : AppCompatActivity> AppCompatActivity.extStartActivity(className: Class<T>) {
    startActivity(Intent(this, MainActivity::class.java))
}
