package com.homework.uilistshomework

sealed class Item {
    data class TypeFirst( val name: String, val shape: Int): Item()
    data class TypeSecond(val name: String, val shape: Int): Item()
    data class TypeThird( val name: String, val shape: Int): Item()
}

