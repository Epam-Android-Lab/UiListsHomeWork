package com.homework.uilistshomework

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class Adapter : ListAdapter<Item, BaseViewHolder>(Item.Diff), IchangeList {


    override fun removeItemUpdate(item: Item) {
        submitList(currentList.filter { it != item })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            FIRST_TYPE -> FirstViewHolder(parent, this)
            SECOND_TYPE -> SecondViewHolder(parent,this)
            else -> ThirdViewHolder(parent,this)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is Item.TypeFirst -> (holder as FirstViewHolder).bind(item)
            is Item.TypeSecond -> (holder as SecondViewHolder).bind(item)
            is Item.TypeThird -> (holder as ThirdViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Item.TypeFirst -> FIRST_TYPE
            is Item.TypeSecond -> SECOND_TYPE
            is Item.TypeThird -> THIRD_TYPE
        }
    }

    companion object {
        const val FIRST_TYPE = 1
        const val SECOND_TYPE = 2
        const val THIRD_TYPE = 3
    }
}
