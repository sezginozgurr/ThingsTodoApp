package com.example.thingstodoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.thingstodoapp.fragment.DayFragment
import com.example.thingstodoapp.fragment.MountFragment
import com.example.thingstodoapp.fragment.WeekFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomePage : AppCompatActivity() {

    lateinit var dayFragment: DayFragment
    lateinit var weekFragment: WeekFragment
    lateinit var mountFragment: MountFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        val bottomNavigationBar: BottomNavigationView = findViewById(R.id.btn_nav)
        bottomNavigationBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    dayFragment = DayFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, dayFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
                R.id.favorite -> {
                    weekFragment = WeekFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, weekFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
                R.id.profile -> {
                    mountFragment = MountFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, mountFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
            }
            true
        }
    }

}