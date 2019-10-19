package com.example.protolm.model.entities

import android.app.Application

class ScriptRepository(val app: Application){

    val pref: Prefs = Prefs(app)













    fun saveChar(char: Character){
        pref.saveChar(char)
    }
}