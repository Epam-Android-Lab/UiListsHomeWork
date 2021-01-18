package com.homework.uilistshomework

import android.view.LayoutInflater
import android.view.ViewGroup
import com.homework.uilistshomework.databinding.ItemTabFirstBinding

class ThirdViewHolder(private val binding: ItemTabFirstBinding,
                      private val clickRemoveItem : IchangeList) : BaseViewHolder(binding.root) {

    constructor(parent: ViewGroup, clickRemoveItem: IchangeList) : this(
        ItemTabFirstBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        clickRemoveItem
    )

    init {
        binding.deleteItem.setOnClickListener {
            clickRemoveItem.removeItemUpdate(adapterPosition)
        }
    }

    fun bind(item: Item) {
        binding.itemText.setBackgroundResource(item.shape)
        binding.itemText.text = item.name
    }
}