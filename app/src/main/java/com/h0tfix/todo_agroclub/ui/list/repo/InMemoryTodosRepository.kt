package com.h0tfix.todo_agroclub.ui.list.repo

import com.h0tfix.todo_agroclub.data.Todo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext

class InMemoryTodosRepository(
    val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : TodosRepository {

    private val todosFlow = MutableStateFlow(
        List(10) { Todo.random() }
    )

    override suspend fun getTodos(): Flow<List<Todo>> = todosFlow

    override suspend fun add(newTodo: Todo) {
        withContext(dispatcher) {
            todosFlow.value = todosFlow.value + newTodo
        }
    }

    override suspend fun remove(id: String) {
        withContext(dispatcher) {
            val curr = todosFlow.value
            val found = curr.firstOrNull { it.id == id }
            val newList = found?.let { curr - it } ?: curr
            todosFlow.value = newList
        }
    }
}