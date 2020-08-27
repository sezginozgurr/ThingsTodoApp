package com.example.thingstodoapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.thingstodoapp.fragment.DayFragment
import com.example.thingstodoapp.fragment.MonthFragment
import com.example.thingstodoapp.fragment.WeekFragment


class ViewPagerAdapter(
    fragmentManager: FragmentActivity
) : FragmentStateAdapter(fragmentManager) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                DayFragment()
            }
            1 -> {
                WeekFragment()
            }
            2 -> {
                MonthFragment()
            }
            else -> DayFragment()
        }
    }

}