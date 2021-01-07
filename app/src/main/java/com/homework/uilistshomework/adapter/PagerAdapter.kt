package com.homework.uilistshomework.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.homework.uilistshomework.fragments.FirstTabFragment
import com.homework.uilistshomework.fragments.SecondTabFragment


// адаптер для ViewPager'a
@Suppress("DEPRECATION")
class PagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    // количество табов
    override fun getCount(): Int {
        return 2
    }
    // возвращаем фрагмент по позициям
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> FirstTabFragment()
            1 -> SecondTabFragment()
            else -> getItem(position)
        }
    }

}