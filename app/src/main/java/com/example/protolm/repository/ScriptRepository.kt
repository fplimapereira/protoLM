package com.example.protolm.repository

import android.app.Application
import com.example.protolm.model.entities.Character
import com.example.protolm.model.entities.Prefs

class ScriptRepository(val app: Application){

    val pref: Prefs = Prefs(app)













    fun saveChar(char: Character){
        pref.saveChar(char)
    }
}