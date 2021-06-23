package com.h0tfix.todo_agroclub.ui.list.repo

import com.h0tfix.todo_agroclub.data.Todo
import kotlinx.coroutines.flow.Flow

interface TodosRepository {

    suspend fun getTodos(): Flow<List<Todo>>

    suspend fun add(newTodo: Todo)

    suspend fun remove(id: String)

}