package com.example.protolm.model.entities

import javax.inject.Inject

data class Character @Inject constructor(var dext: Int,
                     var life: Int,
                     var belief: Int,
                     var critAttack: Boolean,
                     var fastRegen: Boolean,
                     var preVal: Boolean,
                     var credits: Int) {


}