package com.example.protolm.data

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import com.example.protolm.R

class Prefs (context: Context) {

    private val PREF_NAME = "personagem"

    private lateinit var char: Character

    val DEX =  "dexterity"
    val MAXDEX = "maxDexterity"
    val LIFE = "life"
    val MAXLIFE = "maxLife"
    val BEL = "belief"
    val MAXBEL = "maxBel"
    val CA = "critical attack"
    val FR = "fast regeneration"
    val PE = "precise evaluation"


    val prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, 0)


    var dexterity: Int
        get() = prefs.getInt(DEX, 0)
        set(value) = prefs.edit().putInt(DEX, value).apply()

    var maxDexterity: Int
        get() = prefs.getInt(MAXDEX, 0)
        set(value) = prefs.edit().putInt(MAXDEX, value).apply()

    var life: Int
        get() = prefs.getInt(LIFE, 0)
        set(value) = prefs.edit().putInt(LIFE, value).apply()

    var maxLife: Int
        get() = prefs.getInt(MAXLIFE, 0)
        set(value) = prefs.edit().putInt(MAXLIFE, value).apply()

    var belief: Int
        get() = prefs.getInt(BEL, 0)
        set(value) = prefs.edit().putInt(BEL, value).apply()

    var maxBelief: Int
        get() = prefs.getInt(MAXBEL, 0)
        set(value) = prefs.edit().putInt(MAXBEL, value).apply()

    var critAttk: Boolean
        get() = prefs.getBoolean(CA, false)
        set(value) = prefs.edit().putBoolean(BEL, value).apply()

    var fastRegen: Boolean
        get() = prefs.getBoolean(FR, false)
        set(value) = prefs.edit().putBoolean(FR, value).apply()

    var precEval: Boolean
        get() = prefs.getBoolean(PE, false)
        set(value) = prefs.edit().putBoolean(PE, value).apply()


    fun saveChar(char: Character){
        dexterity = char.dext
        maxDexterity = char.maxDext
        life = char.life
        maxLife = char.maxLife
        belief = char.belief
        maxBelief = char.maxBelief
        critAttk = char.critAttack
        fastRegen = char.fastRegen
        precEval = char.preVal

    }

    fun applyEffectCaseEight(): Boolean{
        life = life.minus(2)
        belief = belief.plus(1)
        if(belief > maxBelief) belief = maxBelief
        return life <= 0
    }

    fun applyEffectCaseOne(){
        dexterity.plus(1)
        maxDexterity.plus(1)
    }
}