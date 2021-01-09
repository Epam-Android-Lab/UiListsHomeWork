package com.homework.uilistshomework

import java.util.*

sealed class Item() {
    val id = UUID.randomUUID()

    //data class Name (val name: Int, val dd: Int)
    data class Address(val address: String) : Item() {}
    data class Info(val name: Name, val number: Number):Item(){
        data class Name(val name: String):Item()
        data class Number (val phone: String):Item()
    }
}
