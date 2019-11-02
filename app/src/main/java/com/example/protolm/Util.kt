package com.example.protolm

import kotlin.random.Random

class Util {

    private constructor()

    companion object{

        private lateinit var instance: Util

        val utilInstance: Util
        get() {
            if (instance == null) {
                instance = Util()
            }
            return instance
        }
    }

    fun rollDice(): Int = Random.nextInt((6 - 1) + 1)
}