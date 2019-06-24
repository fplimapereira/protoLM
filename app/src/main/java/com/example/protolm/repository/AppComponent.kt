package com.example.protolm.repository

import com.example.protolm.App
import dagger.Component
import javax.inject.Singleton

@Suppress("unused")
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)
}