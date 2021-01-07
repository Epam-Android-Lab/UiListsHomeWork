package com.homework.uilistshomework.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.homework.uilistshomework.BaseViewHolder
import com.homework.uilistshomework.Item
import com.homework.uilistshomework.databinding.ItemCatBinding
import com.homework.uilistshomework.databinding.ItemDogBinding
import com.homework.uilistshomework.databinding.ItemHeaderBinding

class Adapter: RecyclerView.Adapter<BaseViewHolder>() {
    // лист, который будет показываться
    var list = emptyList<Item>()
        // переопределенный сеттер
        set(value){
            field = value
            notifyDataSetChanged()
        }
    // возвращаем холдер в зависимости от айтема
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType) {
            CAT_ITEM_TYPE -> CatViewHolder(parent)
            DOG_ITEM_TYPE -> DogViewHolder(parent)
            else -> HeaderViewHolder(parent)
        }
    }
    // биндим в зависимости от холдера
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(val item = list[position]){
            is Item.Cat -> (holder as CatViewHolder).bind(item)
            is Item.Dog -> (holder as DogViewHolder).bind(item)
            is Item.Header -> (holder as HeaderViewHolder).bind(item)
        }
    }
    // получаем тип элемента
    override fun getItemViewType(position: Int): Int {
        return when(list[position]) {
            is Item.Cat -> CAT_ITEM_TYPE
            is Item.Dog -> DOG_ITEM_TYPE
            is Item.Header -> HEADER_ITEM_TYPE
        }
    }
    // размер листа
    override fun getItemCount(): Int {
        return list.size
    }
    // номера айтемов
    companion object {
        const val CAT_ITEM_TYPE = 1
        const val DOG_ITEM_TYPE = 2
        const val HEADER_ITEM_TYPE = 3
    }

    // три вьюхолдера, на каждый тип элементов
    class CatViewHolder(private val binding: ItemCatBinding) : BaseViewHolder(binding.root) {

        constructor(parent: ViewGroup): this(
            ItemCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        override fun bind(item: Item) {
            binding.textViewCat.text = (item as Item.Cat).breed
        }
    }

    class DogViewHolder(private val binding: ItemDogBinding) : BaseViewHolder(binding.root) {

        constructor(parent: ViewGroup) : this(
            ItemDogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        override fun bind(item: Item) {
            binding.textViewDog.text = (item as Item.Dog).breed
        }
    }

    class HeaderViewHolder(private val binding: ItemHeaderBinding) : BaseViewHolder(binding.root) {

        constructor(parent: ViewGroup) : this(
            ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        override fun bind(item: Item) {
            binding.textViewHeader.text = (item as Item.Header).animal
        }
    }
}
