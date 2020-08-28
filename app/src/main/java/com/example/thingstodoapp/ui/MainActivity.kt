package com.example.thingstodoapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.thingstodoapp.R
import com.example.thingstodoapp.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adapter by lazy { ViewPagerAdapter(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pager.adapter = adapter
        val tabLayoutMediator = TabLayoutMediator(tab_layout, pager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = "Day"
                     /*   tab.setIcon(R.drawable.ic_baseline)
                        val badge: BadgeDrawable = tab.orCreateBadge
                        badge.backgroundColor =
                            ContextCompat.getColor(applicationContext, R.color.linkedin)*/
                    }
                    1 -> {
                        tab.text = "Week"
                        /* tab.setIcon(R.drawable.ic_next_week)*/


                    }
                    2 -> {
                        tab.text = "Month"
                        /*tab.setIcon(R.drawable.ic_baseline_monetization_on_24)*/
                    }
                }

            })
        tabLayoutMediator.attach()
    }
}