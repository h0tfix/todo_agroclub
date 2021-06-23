package com.h0tfix.todo_agroclub.ui.list

import com.github.terrakok.cicerone.Screen
import com.h0tfix.todo_agroclub.data.Todo
import com.h0tfix.todo_agroclub.ui.list.repo.TodosRepository
import com.h0tfix.todo_agroclub.ui.nav.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import me.dmdev.rxpm.PresentationModel
import me.dmdev.rxpm.action
import me.dmdev.rxpm.state
import java.util.concurrent.Executors

class TodoListPM(
    private val repo: TodosRepository
) : PresentationModel() {

    val items = state<List<Todo>>(emptyList())
    val navigation = state<Screen>()

    private val scope = CoroutineScope(Executors.newSingleThreadExecutor().asCoroutineDispatcher())

    init {
        scope.launch {
            repo.getTodos()
                .shareIn(
                    scope,
                    replay = 1,
                    started = SharingStarted.WhileSubscribed()
                )
                .collect {
                    items.accept(it)
                }
        }
    }

    val todoClicks = action<Todo> {
        this.doOnNext {
            navigation.accept(Screens.Todo(it.id))
        }
    }

    val todoAddClicks = action<Unit> {
        this.doOnNext {
            scope.launch {
                repo.add(Todo.random())
            }
        }
    }

    val todoRemoveClicks = action<Todo> {
        this.doOnNext {
            scope.launch {
                repo.remove(it.id)
            }
        }
    }

}