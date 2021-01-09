package com.homework.uilistshomework

import kotlin.random.Random

object Person {
    private val names = listOf(
        "John",
        "Andrew",
        "Max",
        "Kate",
        "William",
        "Michael",
        "Alexander",
        "Liam"
    )

    private val address = listOf(
        "Ulitsa Karla Marksa, 32А",
        "Ulitsa Belinskogo",
        "Ulitsa El'tonskaya, 38",
        "Ulitsa Kanashskaya, 50/52",
        "Ulitsa Gogolya, 32",
        "Rozhdestvenskaya St, 19",
        "Ulitsa Dolzhanskaya, 2А, к.1",
        "Ulitsa Kostina, 13 к 1"
    )
    private val phone = listOf(
        "+79092195133",
        "+79623551103",
        "+79879024721",
        "+74950401905",
        "+74951457164",
        "+74951978445",
        "+74951359202",
        "+79663381734"

    )
    private const val DEFAULT_SIZE = 50

    @ExperimentalStdlibApi
    fun getDefaultSizeNameList() = buildList(DEFAULT_SIZE) {
        for (i in 0 until DEFAULT_SIZE) add(getRandomItem())
    }

    @ExperimentalStdlibApi
    fun getDefaultStringNameList() = buildList(DEFAULT_SIZE) {
        for (i in 0 until DEFAULT_SIZE) add(getRandomItemString())
    }

    private fun getRandomItem(): Item.Address {
        return Item.Address(address[Random.nextInt(8)])
    }

    private fun getRandomItemString(): Item.Info {
        return Item.Info(
            Item.Info.Name(names[Random.nextInt(8)]),
            Item.Info.Number(phone[Random.nextInt(8)])
        )
    }

}