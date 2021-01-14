package com.homework.uilistshomework

import android.view.LayoutInflater
import android.view.ViewGroup
import com.homework.uilistshomework.databinding.ItemTabFirstBinding

class ThirdViewHolder(private val binding: ItemTabFirstBinding) : BaseViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
            ItemTabFirstBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun bind(item: Item, click: Adapter.Idelete, position: Int) {
        binding.itemText.setBackgroundResource(item.shape)
        binding.itemText.text = item.name
        binding.deleteItem.setOnClickListener {
            click.removeListItem(position)
        }
    }
}