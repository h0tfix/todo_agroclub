package com.h0tfix.todo_agroclub.ui.nav

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val navModule = DI.Module("navigation") {

    bind<Cicerone<Router>>() with singleton { Cicerone.create() }
    bind<Router>() with singleton { instance<Cicerone<Router>>().router }
    bind<NavigatorHolder>() with singleton { instance<Cicerone<Router>>().getNavigatorHolder() }

}