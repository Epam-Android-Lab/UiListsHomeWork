package com.homework.uilistshomework

import android.view.LayoutInflater
import android.view.ViewGroup
import com.homework.uilistshomework.databinding.ItemTabFirstBinding

class ThirdViewHolder(private val binding: ItemTabFirstBinding) : BaseViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
            ItemTabFirstBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun bind(item: Item.TypeThird) {
        binding.itemText.setBackgroundResource(item.shape)
        binding.itemText.text = item.name
    }
}