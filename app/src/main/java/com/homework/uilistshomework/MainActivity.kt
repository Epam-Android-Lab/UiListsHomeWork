package com.homework.uilistshomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.homework.uilistshomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val adapter = Adapter()
    private var listFirst = ItemsFactory.getItemListItemFirstTab()
    private var listSecond = ItemsFactory.getItemListItemSecondTab()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter
        adapter.submitList(listFirst)

        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position.toString()) {
                    "0" -> changeList("${tab.text}", listFirst)
                    "1" -> changeList("${tab.text}", listSecond)
                }
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabReselected(p0: TabLayout.Tab?) {

            }
        })
    }

    fun changeList(tab: String, newList: List<Item>) {
        when (tab) {
            "tab1" -> listSecond = adapter.currentList.toMutableList()
            "tab2" -> listFirst = adapter.currentList.toMutableList()
        }
        adapter.submitList(newList)
    }

}
