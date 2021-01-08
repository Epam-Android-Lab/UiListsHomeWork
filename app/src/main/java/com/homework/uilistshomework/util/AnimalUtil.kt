package com.homework.uilistshomework.util

import com.homework.uilistshomework.Item.*

object AnimalUtil {
    // лист с котиками
    var listOfCats = listOf(
        Cat("Абиссинская"),
        Cat("Австралийская дымчатая"),
        Cat("Азиатская"),
        Cat("Русская"),
        Cat("Шотладская"),
        Cat("Сфинкс"),
        Cat("Веслоухая"),
        Cat("Сиамская"),
        Cat("Бирманская"),
        Cat("Бразильская"),
        Cat("Мейн-кун"),
        Cat("Гималайская"),
        Cat("Манул")
    )
    // лист с собаками
    var listOfDogs = listOf(
        Dog("Самоед"),
        Dog("Немецкая овчарка"),
        Dog("Шотландская овчарка"),
        Dog("Азиатская овчарка"),
        Dog("Маламут"),
        Dog("Хаски"),
        Dog("Королевский пудель"),
        Dog("Доберман"),
        Dog("Алабай"),
        Dog("Шпиц"),
        Dog("Водолаз"),
        Dog("Питбуль"),
        Dog("Бультерьер"),
        Dog("Мопс"),
        Dog("Акита-ину"),
        Dog("Сиба-ину"),
        Dog("Лабрадор"),
    )
    // смешанный лист с заголовком
    fun getMixedList() = listOf(
        Header("Породы собак")
    ) + listOfDogs
}
