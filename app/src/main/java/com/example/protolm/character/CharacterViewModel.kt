package com.example.protolm.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterViewModel: ViewModel() {

    //propriedades de modelo
    private val _credits = MutableLiveData<Int>()
    val credits: LiveData<Int>
        get() = _credits

    private val _dexterity = MutableLiveData<Int>()
    val dexterity: LiveData<Int>
        get() = _dexterity

    private val _life = MutableLiveData<Int>()
    val life: LiveData<Int>
        get() = _life

    private val _belief = MutableLiveData<Int>()
    val belief: LiveData<Int>
        get() = _belief

    private val _criticalAttack = MutableLiveData<Boolean>()
    val criticalAttack: LiveData<Boolean>
        get() = _criticalAttack

    private val _fastRegen = MutableLiveData<Boolean>()
    val fastRegen: LiveData<Boolean>
        get() = _fastRegen

    private val _preciseEvaluation = MutableLiveData<Boolean>()
    val preciseEvaluation: LiveData<Boolean>
        get() = _preciseEvaluation




    //propriedade de validação
    private val _noCreditsError = MutableLiveData<Boolean>()
    val noCreditsError: LiveData<Boolean>
        get() = _noCreditsError

    private val _minimumValue = MutableLiveData<Boolean>()
    val minimumValue: LiveData<Boolean>
        get() = _minimumValue

    private val _creditsLeft = MutableLiveData<Boolean>()
    val creditsLeft: LiveData<Boolean>
        get() = _creditsLeft



    //inicializando a VM
    init {
        _credits.value = 10
        _dexterity.value = 7
        _life.value = 20
        _belief.value = 7
        _criticalAttack.value = false
        _preciseEvaluation.value = false
        _fastRegen.value = false
    }

    //métodos para os botões

    //adiciona destreza
    fun addDex(){
        if(restTwo()){
            _noCreditsError.value = true
        }
        else{
            _credits.value = (_credits.value)?.minus(2)
            _dexterity.value = (_dexterity.value)?.plus(1)
        }
    }

    //remove destreza
    fun removeDexterity(){
        if(verifyMinTwo()){
            _minimumValue.value = true
        }
        else{
            _credits.value = (_credits.value)?.plus(2)
            _dexterity.value = (_dexterity.value)?.minus(1)
        }
    }

    //adiciona vida
    fun addLife(){
        if(restOne()){
            _noCreditsError.value = true
        }
        else{
            _credits.value = (_credits.value)?.minus(1)
            _dexterity.value = (_life.value)?.plus(2)
        }
    }

    //adiciona convicção
    fun addBelief(){
        if(restOne()){
            _noCreditsError.value = true
        }
        else{
            _credits.value = (_credits.value)?.minus(1)
            _dexterity.value = (_belief.value)?.plus(1)
        }
    }





    //métodos de validação de regra do crédito
    private fun restTwo(): Boolean {return (_credits.value!! < 2)}
    private fun restOne(): Boolean {return (_credits.value!! < 1)}
    private fun verifyMinTwo(): Boolean{return (_credits.value!!) > 18 || (_dexterity.value!!) == 7}



}