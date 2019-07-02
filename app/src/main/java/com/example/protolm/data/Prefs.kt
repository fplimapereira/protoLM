package com.example.protolm.data

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import com.example.protolm.R

class Prefs (context: Context) {

    private val PREF_NAME = "personagem"

    val DEX =  "dexterity"
    val LIFE = "life"
    val BEL = "belief"
    val CA = "critical attack"
    val FR = "fast regeneration"
    val PE = "precise evaluation"


    val prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, 0)


    var dexterity: Int
        get() = prefs.getInt(DEX, 0)
        set(value) = prefs.edit().putInt(DEX, value).apply()

    var life: Int
        get() = prefs.getInt(LIFE, 0)
        set(value) = prefs.edit().putInt(LIFE, value).apply()

    var belief: Int
        get() = prefs.getInt(BEL, 0)
        set(value) = prefs.edit().putInt(BEL, value).apply()

    var critAttk: Boolean
        get() = prefs.getBoolean(CA, false)
        set(value) = prefs.edit().putBoolean(BEL, value).apply()

    var fastRegen: Boolean
        get() = prefs.getBoolean(FR, false)
        set(value) = prefs.edit().putBoolean(FR, value).apply()

    var precEval: Boolean
        get() = prefs.getBoolean(PE, false)
        set(value) = prefs.edit().putBoolean(PE, value).apply()
}