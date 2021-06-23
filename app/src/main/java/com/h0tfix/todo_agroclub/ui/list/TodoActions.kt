package com.h0tfix.todo_agroclub.ui.list

import com.h0tfix.todo_agroclub.data.Todo

interface TodoActions {

    fun onDetails(todo: Todo)

    fun onRemove(todo: Todo)

}