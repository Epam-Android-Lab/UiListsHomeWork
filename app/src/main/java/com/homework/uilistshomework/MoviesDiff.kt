package com.homework.uilistshomework

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback

class MoviesDiff(var oldData: List<Item>, var newData: List<Item>) : ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        val old : Item = oldItem
        val new : Item = newItem
        //return old = new
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        TODO("Not yet implemented")
    }
}