package com.example.protolm.repository

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import com.example.protolm.App
import com.example.protolm.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Suppress("unused")
    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences = app.getSharedPreferences(Resources.getSystem().getString(
        R.string.pref_key), Context.MODE_PRIVATE)

}