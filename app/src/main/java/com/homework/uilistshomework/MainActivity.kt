package com.homework.uilistshomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout
import com.homework.uilistshomework.databinding.ActivityMainBinding
import com.homework.uilistshomework.databinding.ItemAddressBinding

class MainActivity : AppCompatActivity() {
    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tab = binding.tabLayout
        val d = tab.getTabAt(0)
        val adapter = Adapter().apply {
            list = Person.getDefaultSizeNameList()
        }

        binding.recyclerView.adapter = adapter
        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (d != null) {
                    if (d.isSelected) {
                        val adapter = Adapter().apply {
                            list = Person.getDefaultSizeNameList()
                        }
                        binding.recyclerView.adapter = adapter
                    } else {
                        val adapter = Adapter().apply {
                            list = Person.getDefaultStringNameList()
                        }
                        binding.recyclerView.adapter = adapter
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselect
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselect
            }
        })
    }
}
