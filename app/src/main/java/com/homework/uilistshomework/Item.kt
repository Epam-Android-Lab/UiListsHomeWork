package com.homework.uilistshomework

sealed class Item {
    data class Cat(val breed: String) : Item()
    data class Dog(val breed: String) : Item()
    data class Header(val animal: String) : Item()
}
