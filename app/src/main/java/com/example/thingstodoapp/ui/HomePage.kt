package com.example.thingstodoapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.thingstodoapp.R
import com.example.thingstodoapp.fragment.DayFragment
import com.example.thingstodoapp.fragment.MountFragment
import com.example.thingstodoapp.fragment.WeekFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        loadFragment(DayFragment())
        clickFunction()

    }


    fun clickFunction() {
        val bottomNavigationBar: BottomNavigationView = findViewById(R.id.btn_nav)
        bottomNavigationBar.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val fragment: Fragment
            when (item.itemId) {
                R.id.home -> {
                    fragment = DayFragment()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.favorite -> {
                    fragment = WeekFragment()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profile -> {
                    fragment = MountFragment()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
//                R.id.profile -> {
//                    fragment = ProfileFragment()
//                    loadFragment(fragment)
//                    return@OnNavigationItemSelectedListener true
//                }
            }
            false
        })
    }


    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction =
            supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}