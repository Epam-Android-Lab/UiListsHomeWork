package com.homework.uilistshomework

import android.view.LayoutInflater
import android.view.ViewGroup
import com.homework.uilistshomework.databinding.ItemTabFirstBinding
import com.homework.uilistshomework.databinding.ItemTabSecondBinding

class SecondViewHolder(private val binding: ItemTabSecondBinding,
                       private val clickRemoveItem : IchangeList) : BaseViewHolder(binding.root) {

    constructor(parent: ViewGroup, clickRemoveItem: IchangeList) : this(
        ItemTabSecondBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        clickRemoveItem
    )

    fun bind(item: Item) {
        binding.itemText.setBackgroundResource(item.shape)
        binding.itemText.text = item.name
        addListener(item)
    }

    private var item: Item? = null

    override fun addListener(item: Item) {
        if (this.item == null) {
            binding.deleteItem.setOnClickListener {
                clickRemoveItem.removeItemUpdate(item)
            }
            this.item = item
        }
    }
}
