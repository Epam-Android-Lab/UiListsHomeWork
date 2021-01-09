package com.homework.uilistshomework

import android.view.LayoutInflater
import android.view.ViewGroup
import com.homework.uilistshomework.databinding.ItemTabFirstBinding

class FirstViewHolder(private val binding: ItemTabFirstBinding) : BaseViewHolder(binding.root) {

    constructor(parent: ViewGroup): this (
            ItemTabFirstBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun bind(item: Item.TypeFirst) {
        binding.itemText.setBackgroundResource(item.shape)
        binding.itemText.text = item.name
    }

}