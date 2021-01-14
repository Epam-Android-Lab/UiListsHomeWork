package com.homework.uilistshomework

import android.view.LayoutInflater
import android.view.ViewGroup
import com.homework.uilistshomework.databinding.ItemTabSecondBinding

class SecondViewHolder(private val binding: ItemTabSecondBinding) : BaseViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
            ItemTabSecondBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun bind(item: Item.TypeSecond, click: Adapter.Idelete, position: Int) {
        binding.itemText.setBackgroundResource(item.shape)
        binding.itemText.text = item.name
        binding.deleteItem.setOnClickListener {
            click.removeListItem(position)
        }
    }
}
