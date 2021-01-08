package com.homework.uilistshomework

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.homework.uilistshomework.databinding.ItemAddressBinding
import com.homework.uilistshomework.databinding.ItemInfoBinding

class ListAdapterExample (private val click: () -> Unit)
    //ListAdapter<Item, BaseViewHolder>(MoviesDiff())
{

//    fun ListAdapterExample() {
//        super(User.DIFF_CALLBACK)
//    }
//    constructor() {
//        super(ListAdapter.DIFF_CALLBACK)
//    }
    var list: List<Item> = emptyList()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }
//    fun DIFF_CALLBACK : DiffUtil.ItemCallback<Item>  =
//    new DiffUtil.ItemCallback<User>()
//    {
//        @Override
//        public boolean areItemsTheSame(
//            @NonNull User oldUser, @NonNull User newUser
//        ) {
//            // User properties may have changed if reloaded from the DB, but ID is fixed
//            return oldUser.getId() == newUser.getId();
//        }
//        @Override
//        public boolean areContentsTheSame(
//            @NonNull User oldUser, @NonNull User newUser
//        ) {
//            // NOTE: if you use equals, your object must properly override Object#equals()
//            // Incorrectly returning false here will result in too many animations.
//            return oldUser.equals(newUser);
//        }
//    }
      fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        Log.d("KUKU", "KUKU")
        Log.d(viewType.toString(), viewType.toString())
        Log.d(viewType.toString(), viewType.toString())
        Log.d(viewType.toString(), viewType.toString())
        println(viewType)
        println(viewType)
        return when (viewType) {
            R.layout.item_address -> AddressViewHolder(parent)
            //R.layout.item_info -> InfoViewHolder(parent)
            else -> InfoViewHolder(parent)

        }
    }

     fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is Item.Address -> R.layout.item_address
            is Item.Info -> R.layout.item_info
            else -> 0
        }
    }

     fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        when (val item = list[position]) {
            is Item.Address -> (holder as AddressViewHolder).bind(item)
//                val item = list[position]
//                holder.bind(item)
//                itemCount
//            }
            is Item.Info -> (holder as InfoViewHolder).bind(item)
//                val item = list[position]
//                itemCount
//                holder.bind(item)
            // }
        }

    }


    class AddressViewHolder(private val binding: ItemAddressBinding) :
        BaseViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
            ItemAddressBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        override fun bind(item: Item) {
            val tmpCast: Item.Address = item as Item.Address
            binding.itemAddress.text = tmpCast.address
        }
    }

    class InfoViewHolder(private val binding: ItemInfoBinding) :
        BaseViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
            ItemInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        @SuppressLint("SetTextI18n")
        override fun bind(item: Item) {
//            if (item in Item.Info) {
//
//            }
            val tmpCast: Item.Info = item as Item.Info
            binding.itemInfo.text = tmpCast.name.name +"\nCall "+ tmpCast.number.phone
        }
    }

 }
