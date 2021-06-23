package com.h0tfix.todo_agroclub.data

import java.util.*
import kotlin.random.Random

data class Todo(
    val id: String = UUID.randomUUID().toString(),
    val priority: Int,
    val title: String
) {

    companion object {
        fun random() =
            Todo(priority = Random.nextInt(10), title = "todo#${Random.nextInt(1_000_000)}")
    }

}