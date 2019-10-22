package com.example.protolm.model.entities

import javax.inject.Inject

data class Character @Inject constructor(var dext: Int,
                     var maxDex:Int,
                     var life: Int,
                     var maxLife: Int,
                     var belief: Int,
                     var maxBelief: Int,
                     var critAttack: Boolean,
                     var fastRegen: Boolean,
                     var preVal: Boolean,
                     var credits: Int) {


    fun addDextery(credit: Int): Boolean = this.restTwo(credit!!)

    fun removeDexterity(credit: Int, dexterity: Int): Boolean = this.verifyMinTwo(credit, dexterity)

    fun addLife(credit: Int): Boolean = this.restOne(credit)

    fun removeLife(credit: Int, life: Int): Boolean = this.verifyMinLife(credit, life)

    fun addBelief(credit: Int): Boolean = this.restOne(credit)

    fun removeBelief(credit: Int, belief: Int): Boolean = this.verifyMinBelief(credit, belief)

    fun verifySkill(skill: Boolean, credit: Int): Int{
        return if(skill && !this.restTwo(credit)) 1
        else {
            if (skill && this.restTwo(credit)) 2
            else {
                3
            }
        }
    }


    fun spendPoints(credit: Int): Boolean = credit == 0

    //métodos de validação de regra do crédito

    private fun restTwo(credit: Int): Boolean {return credit < 2}

    private fun restOne(credit: Int): Boolean {return credit < 1}

    private fun verifyMinTwo(credit: Int, dexterity: Int): Boolean{return credit > 8 || dexterity == 7}

    private fun verifyMinLife(credit: Int, life: Int): Boolean{return credit > 9 || life == 20}

    private fun verifyMinBelief(credit: Int, belief: Int): Boolean{return credit > 9 || belief == 7}


}