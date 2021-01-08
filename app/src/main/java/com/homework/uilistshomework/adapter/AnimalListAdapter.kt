package com.homework.uilistshomework.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.homework.uilistshomework.Item
import com.homework.uilistshomework.databinding.ItemCatBinding

// адаптер для второго задания
class AnimalListAdapter(
    private val diffCallback: AnimalDiffCallback,
    val animalClickInterface: AnimalClickInterface
) :
    ListAdapter<Item.Cat, AnimalListAdapter.AnimalViewHolder>(diffCallback) {


    inner class AnimalViewHolder(private val binding: ItemCatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        constructor(parent: ViewGroup) : this(
            ItemCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(itemView: Item) {
            binding.textViewCat.text = (itemView as Item.Cat).breed
            binding.imageViewDeleteButton.setOnClickListener {
                animalClickInterface.onDelete(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(parent)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface AnimalClickInterface {
        fun onDelete(position: Int)
    }
}

class AnimalDiffCallback : DiffUtil.ItemCallback<Item.Cat>() {
    override fun areItemsTheSame(oldItem: Item.Cat, newItem: Item.Cat): Boolean {
        return oldItem.breed == newItem.breed
    }

    override fun areContentsTheSame(oldItem: Item.Cat, newItem: Item.Cat): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }

}


