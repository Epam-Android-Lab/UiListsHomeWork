package com.homework.uilistshomework

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter : RecyclerView.Adapter<BaseViewHolder>() {

    var list: List<Item> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            FIRST_TYPE -> FirstViewHolder(parent)
            SECOND_TYPE -> SecondViewHolder(parent)
            else -> ThirdViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (val item = list[position]) {
            is Item.TypeFirst -> (holder as FirstViewHolder).bind(item)
            is Item.TypeSecond -> (holder as SecondViewHolder).bind(item)
            is Item.TypeThird -> (holder as ThirdViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
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
