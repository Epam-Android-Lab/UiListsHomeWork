package com.homework.uilistshomework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.homework.uilistshomework.R
import com.homework.uilistshomework.adapter.Adapter
import com.homework.uilistshomework.databinding.FragmentSecondTabFrgamentBinding
import com.homework.uilistshomework.util.AnimalUtil

class SecondTabFragment : Fragment(R.layout.fragment_second_tab_frgament) {

    private lateinit var binding: FragmentSecondTabFrgamentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondTabFrgamentBinding.inflate(inflater, container, false)
        binding.recyclerViewTab2.layoutManager = LinearLayoutManager(context)
        val adapter = Adapter()
        binding.recyclerViewTab2.adapter = adapter
        adapter.list = AnimalUtil.getMixedList()

        return binding.root
    }

}