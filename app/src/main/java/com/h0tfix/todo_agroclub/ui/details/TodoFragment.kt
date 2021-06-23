package com.h0tfix.todo_agroclub.ui.details

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.h0tfix.todo_agroclub.R
import com.h0tfix.todo_agroclub.databinding.FragmentTodoBinding
import com.h0tfix.todo_agroclub.ui.util.viewBinding
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.closestDI
import org.kodein.di.instance


class TodoFragment : Fragment(R.layout.fragment_todo), DIAware {

    override val di: DI by closestDI()

    private val binding: FragmentTodoBinding by viewBinding()
    private val router: Router by instance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            router.exit()
        }
    }

    companion object {
        private const val ARG_ID = "id"
        fun newInstance(id: String?): TodoFragment {
            return TodoFragment().apply {
                arguments = bundleOf(ARG_ID to id)
            }
        }
    }

}