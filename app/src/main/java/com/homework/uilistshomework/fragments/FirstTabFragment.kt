package com.homework.uilistshomework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.homework.uilistshomework.R
import com.homework.uilistshomework.adapter.Adapter
import com.homework.uilistshomework.databinding.FragmentFirstTabBinding
import com.homework.uilistshomework.util.AnimalUtil

class FirstTabFragment : Fragment(R.layout.fragment_first_tab) {

    private lateinit var binding: FragmentFirstTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstTabBinding.inflate(inflater, container, false)
        binding.recyclerViewTab1.layoutManager = LinearLayoutManager(context)
        val adapter = Adapter()
        binding.recyclerViewTab1.adapter = adapter
        adapter.list = AnimalUtil.listOfCats

        return binding.root
    }

}