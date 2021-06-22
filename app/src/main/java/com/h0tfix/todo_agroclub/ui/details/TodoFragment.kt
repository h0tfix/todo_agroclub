package com.h0tfix.todo_agroclub.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.h0tfix.todo_agroclub.R
import com.h0tfix.todo_agroclub.databinding.FragmentTodoBinding
import com.h0tfix.todo_agroclub.ui.util.viewBinding


class TodoFragment : Fragment(R.layout.fragment_todo) {

    private val binding: FragmentTodoBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.toTodoList)
        }
    }

}