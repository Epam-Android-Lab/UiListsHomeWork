package com.homework.uilistshomework

import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil

sealed class Item {

    abstract val name: String
    abstract val shape: Int

    companion object Diff : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

    data class TypeFirst(override val name: String, @DrawableRes override val shape: Int) : Item()
    data class TypeSecond(override val name: String, @DrawableRes override val shape: Int) : Item()
    data class TypeThird(override val name: String, @DrawableRes override val shape: Int) : Item()
}

