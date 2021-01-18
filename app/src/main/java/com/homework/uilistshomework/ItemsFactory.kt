package com.homework.uilistshomework

import kotlin.random.Random


object ItemsFactory {

    private val shape = listOf(
            R.drawable.second_shape_type,
            R.drawable.third_shape_type,
            R.drawable.first_shape_type
    )

    fun getItemListItemFirstTab(size: Int = 20): MutableList<Item> {
        val list: MutableList<Item> = ArrayList()
        for (i in 0 until size) list.add(Item.TypeFirst("Item $i", shape[2]))
        return list
    }

    fun getItemListItemSecondTab(size: Int = 20): MutableList<Item> {
        val list: MutableList<Item> = ArrayList()
        for (i in 0 until size) list.add(getRandomItem(i))
        return list
    }

    private fun getRandomItem(id: Int): Item {
        return when (val shape = getRandomShape()) {
            R.drawable.second_shape_type -> Item.TypeSecond("Item $id", shape)
            R.drawable.third_shape_type -> Item.TypeThird("Item $id", shape)
            else -> Item.TypeSecond("Item $id", 0)
        }
    }

    private fun getRandomShape(): Int = shape[Random.nextInt(2)]

}