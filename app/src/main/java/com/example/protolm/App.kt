package com.example.protolm
import android.app.Application
import com.example.protolm.data.Prefs


open class App : Application(){

    companion object {
        var prefs: Prefs? = null
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
    }
}