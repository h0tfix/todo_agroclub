package com.h0tfix.todo_agroclub.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.h0tfix.todo_agroclub.R
import com.h0tfix.todo_agroclub.databinding.FragmentTodoListBinding
import com.h0tfix.todo_agroclub.ui.nav.Screens
import com.h0tfix.todo_agroclub.ui.util.viewBinding
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.closestDI
import org.kodein.di.instance

class TodoListFragment : Fragment(R.layout.fragment_todo_list), DIAware {

    override val di: DI by closestDI()

    private val binding: FragmentTodoListBinding by viewBinding()
    private val router: Router by instance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.binding.buttonFirst.setOnClickListener {
            router.navigateTo(Screens.Todo("test"))
        }
    }

    companion object {
        fun newInstance() = TodoListFragment()
    }

}