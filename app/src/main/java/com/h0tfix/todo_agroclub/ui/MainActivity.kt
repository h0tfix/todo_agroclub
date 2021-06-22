package com.h0tfix.todo_agroclub.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.h0tfix.todo_agroclub.R
import com.h0tfix.todo_agroclub.databinding.ActivityMainBinding
import com.h0tfix.todo_agroclub.ui.list.TodoListFragmentDirections

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener {
            val dir = TodoListFragmentDirections.toTodo().setId(null)
            navController.navigate(dir)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}