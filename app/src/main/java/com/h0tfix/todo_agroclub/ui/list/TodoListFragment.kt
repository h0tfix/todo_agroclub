package com.h0tfix.todo_agroclub.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.terrakok.cicerone.Router
import com.h0tfix.todo_agroclub.data.Todo
import com.h0tfix.todo_agroclub.databinding.FragmentTodoListBinding
import me.dmdev.rxpm.base.PmFragment
import me.dmdev.rxpm.bindTo
import me.dmdev.rxpm.passTo
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.closestDI
import org.kodein.di.instance

class TodoListFragment : PmFragment<TodoListPM>(), DIAware {

    override val di: DI by closestDI()

    private var binding: FragmentTodoListBinding? = null
    private val pm: TodoListPM by instance()
    private val router: Router by instance()

    private lateinit var controller: TodoController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.controller = TodoController(object : TodoActions {
            override fun onDetails(todo: Todo) = todo passTo pm.todoClicks
            override fun onRemove(todo: Todo) = todo passTo pm.todoRemoveClicks
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoListBinding.inflate(inflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.run {
            items.setController(controller)
            addTodo.setOnClickListener { Unit passTo pm.todoAddClicks }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun providePresentationModel() = pm

    override fun onBindPresentationModel(pm: TodoListPM) {
        this.binding?.run {
            pm.items bindTo { controller.setData(it) }
            pm.navigation bindTo { router.navigateTo(it) }
        }
    }

    companion object {
        fun newInstance() = TodoListFragment()
    }

}