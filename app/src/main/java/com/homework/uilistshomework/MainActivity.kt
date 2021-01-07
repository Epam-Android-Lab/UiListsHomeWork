package com.homework.uilistshomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.homework.uilistshomework.adapter.PagerAdapter
import com.homework.uilistshomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabsMain.addTab(binding.tabsMain.newTab().setText("First Fragment Tab"))
        binding.tabsMain.addTab(binding.tabsMain.newTab().setText("Second Fragment Tab"))
        binding.tabsMain.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = PagerAdapter(supportFragmentManager)
        binding.viewpagerMain.adapter = adapter
        binding.viewpagerMain.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(binding.tabsMain)
        )
        binding.tabsMain.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewpagerMain.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }
}
