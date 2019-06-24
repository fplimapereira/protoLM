package com.example.protolm

import android.app.Application
import com.example.protolm.repository.AppComponent
import com.example.protolm.repository.AppModule
import com.example.protolm.repository.DaggerAppComponent

open class App : Application(){

   private val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

}