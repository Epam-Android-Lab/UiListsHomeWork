package com.homework.uilistshomework

import android.view.LayoutInflater
import android.view.ViewGroup
import com.homework.uilistshomework.databinding.ItemTabSecondBinding

class SecondViewHolder(private val binding: ItemTabSecondBinding) : BaseViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
            ItemTabSecondBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun bind(item: Item.TypeSecond) {

        binding.itemText.setBackgroundResource(item.shape)
        binding.itemText.text = item.name
    }
}
