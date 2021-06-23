package com.h0tfix.todo_agroclub.ui.list

import com.airbnb.epoxy.TypedEpoxyController
import com.h0tfix.todo_agroclub.EpoxyItemTodoBindingModel_
import com.h0tfix.todo_agroclub.data.Todo
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

class TodoController(
    private val actions: TodoActions? = null
) : TypedEpoxyController<List<Todo>>() {

    override fun buildModels(data: List<Todo>?) {
        data?.forEach {
            EpoxyItemTodoBindingModel_()
                .id(it.id)
                .title(it.title)
                .priority(priorityText(it.priority))
                .dateDue(OffsetDateTime.now().format(DateTimeFormatter.ISO_DATE))
                .onDetails { _ -> actions?.onDetails(it) }
                .onRemove { _ -> actions?.onRemove(it) }
                .addTo(this)
        }
    }

    private fun priorityText(priority: Int) =
        when {
            priority < 4 -> "low"
            priority in 5..6 -> "medium"
            priority > 7 -> "high"
            else -> "none"
        }
}