package com.h0tfix.todo_agroclub.ui.list

import com.h0tfix.todo_agroclub.ui.list.repo.InMemoryTodosRepository
import com.h0tfix.todo_agroclub.ui.list.repo.TodosRepository
import org.kodein.di.*

val todoListModule = DI.Module("todo_list") {

    bind<TodosRepository>() with singleton { InMemoryTodosRepository() }

    //todo: fix with scoped instance
    bind<TodoListPM>() with factory { TodoListPM(instance()) }

}