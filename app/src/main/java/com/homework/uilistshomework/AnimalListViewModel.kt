package com.homework.uilistshomework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.homework.uilistshomework.util.AnimalUtil

// вьюмодель, в ней операции с листом
class AnimalListViewModel : ViewModel() {

    private val tag = "AnimalListViewModel"
    private var liveData: MutableLiveData<MutableList<Item.Cat>>? = null

    fun getAnimalList(): LiveData<MutableList<Item.Cat>> {
        if (liveData == null) {
            liveData = MutableLiveData()
            initAnimalList()
        }
        return liveData!!
    }

    private fun initAnimalList() {
        liveData!!.value = AnimalUtil.listOfCats as MutableList
    }

    fun deleteAnimal(position: Int) {
        if (liveData!!.value != null) {
            val list: MutableList<Item.Cat> = mutableListOf()
            list.addAll(liveData!!.value as MutableList)
            list.removeAt(position)
            liveData!!.value = list
        }
    }
}