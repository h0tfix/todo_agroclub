package com.h0tfix.todo_agroclub.ui.nav

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.h0tfix.todo_agroclub.ui.details.TodoFragment
import com.h0tfix.todo_agroclub.ui.list.TodoListFragment

object Screens {

    fun TodoList() = FragmentScreen {
        TodoListFragment.newInstance()
    }

    fun Todo(id: String?) = FragmentScreen {
        TodoFragment.newInstance(id)
    }
}