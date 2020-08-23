package com.example.thingstodoapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.thingstodoapp.fragment.*


internal class PagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(
    fm!!
) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                DayFragment()
            }
            1 -> {
                WeekFragment()
            }
            2 -> {
                MountFragment()
            }
            3 -> {
                SixMountFragment()
            }
            4 -> {
                DetailFragment()
            }
            else -> DayFragment()
        }
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }
}