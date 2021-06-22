package com.h0tfix.todo_agroclub.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.h0tfix.todo_agroclub.R
import com.h0tfix.todo_agroclub.databinding.FragmentTodoListBinding
import com.h0tfix.todo_agroclub.ui.util.viewBinding

class TodoListFragment : Fragment(R.layout.fragment_todo_list) {

    private val binding: FragmentTodoListBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.binding.buttonFirst.setOnClickListener {
            val dir = TodoListFragmentDirections.toTodo().setId(null)
            findNavController().navigate(dir)
        }
    }

}