package com.h0tfix.todo_agroclub.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.h0tfix.todo_agroclub.R
import com.h0tfix.todo_agroclub.databinding.ActivityMainBinding
import com.h0tfix.todo_agroclub.ui.nav.Screens
import org.kodein.di.DIAware
import org.kodein.di.DIContext
import org.kodein.di.android.closestDI
import org.kodein.di.diContext
import org.kodein.di.instance

class MainActivity : AppCompatActivity(), DIAware {

    override val diContext: DIContext<*> = diContext(this)

    override val di by closestDI()

    private lateinit var binding: ActivityMainBinding

    private val navigatorHolder: NavigatorHolder by instance()
    private val router: Router by instance()

    private val navigator = object : AppNavigator(this, R.id.content_main) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        router.navigateTo(Screens.TodoList())
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

}