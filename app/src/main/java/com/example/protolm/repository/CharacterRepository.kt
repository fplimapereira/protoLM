package com.example.protolm.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.protolm.model.entities.Character

class CharacterRepository (context: Context) {

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
    val ATTK = "attack"
    val IP = "ice protection"


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

    var attack: Int
        get() = prefs.getInt(ATTK, 0)
        set(value) = prefs.edit().putInt(ATTK, value).apply()

    var critAttk: Boolean
        get() = prefs.getBoolean(CA, false)
        set(value) = prefs.edit().putBoolean(BEL, value).apply()

    var fastRegen: Boolean
        get() = prefs.getBoolean(FR, false)
        set(value) = prefs.edit().putBoolean(FR, value).apply()

    var precEval: Boolean
        get() = prefs.getBoolean(PE, false)
        set(value) = prefs.edit().putBoolean(PE, value).apply()

    var iceProt: Boolean
        get() = prefs.getBoolean(IP, false)
        set(value) = prefs.edit().putBoolean(IP, value).apply()


    fun saveChar(char: Character){
        dexterity = char.dext
        maxDexterity = char.dext
        life = char.life
        maxLife = char.life
        belief = char.belief
        maxBelief = char.belief
        attack = char.dext
        critAttk = char.critAttack
        fastRegen = char.fastRegen
        precEval = char.preVal

    }

    fun imputEffect(id: Int): Boolean {

        var bol = false

        when (id){
            1-> applyEffectCaseOne()
            2-> applyEffectCaseTwo()
            3-> applyEffectCaseThree()
            4-> applyEffectCaseFour()
            5-> applyEffectCaseFive()
            6-> applyEffectCaseSix()
            7-> applyEffectCaseSeven()
            8-> applyEffectCaseEight()
            9-> applyEffectCaseNine()
            99-> bol = true
        }

        if( life == 0) bol = true

        return bol
    }

    private fun applyEffectCaseOne(){
        dexterity = dexterity.plus(1)
        maxDexterity =maxDexterity.plus(1)
    }

    private fun applyEffectCaseTwo(){
        attack = attack.minus(1)
    }

    private fun applyEffectCaseThree(){
        attack = attack.minus(1)
        life = life.minus(4)
    }

    private fun applyEffectCaseFour(){
        belief = belief.plus(1)
        maxBelief = maxBelief.plus(1)
    }

    private fun applyEffectCaseFive(){
        belief = belief.minus(2)
    }

    private fun applyEffectCaseSix(){
        belief = belief.minus(1)
    }

    private fun applyEffectCaseSeven(){
        dexterity = dexterity.minus(2)
    }

    private fun applyEffectCaseEight(){
        life = life.minus(2)
        belief = belief.plus(1)
        if(belief > maxBelief) belief = maxBelief
    }

    private fun applyEffectCaseNine(){
        iceProt = true
    }
}