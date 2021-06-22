package com.h0tfix.todo_agroclub

import android.app.Application
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule

class TodoApp : Application(), DIAware {

    override val di by DI.lazy {
        import(androidXModule(this@TodoApp))
        //binds here
    }

}