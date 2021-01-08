package com.homework.uilistshomework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.homework.uilistshomework.AnimalListViewModel
import com.homework.uilistshomework.R
import com.homework.uilistshomework.adapter.AnimalDiffCallback
import com.homework.uilistshomework.adapter.AnimalListAdapter
import com.homework.uilistshomework.databinding.FragmentFirstTabBinding


class FirstTabFragment : Fragment(R.layout.fragment_first_tab),
    AnimalListAdapter.AnimalClickInterface {

    private lateinit var binding: FragmentFirstTabBinding
    private lateinit var adapter: AnimalListAdapter
    private lateinit var viewModel: AnimalListViewModel

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
        adapter = AnimalListAdapter(AnimalDiffCallback(), this)
        binding.recyclerViewTab1.adapter = adapter

        viewModel = ViewModelProvider(this).get(AnimalListViewModel::class.java)
        viewModel.getAnimalList().observe(this, {
            adapter.submitList(it)
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.recyclerViewTab1.adapter = null
    }

    override fun onDelete(position: Int) {
        viewModel.deleteAnimal(position)
    }

}

