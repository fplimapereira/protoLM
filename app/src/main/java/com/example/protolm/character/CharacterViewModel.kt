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

    val criticalAttack = MutableLiveData<Boolean>()

    val fastRegen = MutableLiveData<Boolean>()

    val preciseEvaluation = MutableLiveData<Boolean>()



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
        criticalAttack.value = false
        preciseEvaluation.value = false
        fastRegen.value = false
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
    fun removeDex(){
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
            _life.value = (_life.value)?.plus(2)
        }
    }

    //remove vida
    fun removeLife(){
        if(verifyMinLife()){
            _minimumValue.value = true
        }
        else{
            _credits.value = (_credits.value)?.plus(1)
            _life.value = (_life.value)?.minus(2)
        }
    }

    //adiciona convicção
    fun addBelief(){
        if(restOne()){
            _noCreditsError.value = true
        }
        else{
            _credits.value = (_credits.value)?.minus(1)
            _belief.value = (_belief.value)?.plus(1)
        }
    }

    //remove convicção
    fun removeBelief(){
        if(verifyMinBelief()){
            _minimumValue.value = true
        }
        else{
            _credits.value = (_credits.value)?.plus(1)
            _belief.value = (_belief.value)?.minus(1)
        }
    }


    //adiciona e remove Ataque Poderoso
    fun addCrtAttk(){
       if(criticalAttack.value!! && !restTwo()){
           _credits.value = (_credits.value)?.minus(2)
       }
        else if (criticalAttack.value!! && restTwo()){
           criticalAttack.value = false
           _noCreditsError.value = true
       }
        else{
           _credits.value = (_credits.value)?.plus(2)
       }
    }

    //adiciona e remove Regeneração Acelerada
    fun addFastRegen(){
        if(fastRegen.value!! && !restTwo()){
            _credits.value = (_credits.value)?.minus(2)
        }
        else if (fastRegen.value!! && restTwo()){
            fastRegen.value = false
            _noCreditsError.value = true
        }
        else{
            _credits.value = (_credits.value)?.plus(2)
        }
    }

    //adiciona e remove Avaliação Precisa
    fun addPreciseEvaluation(){
        if(preciseEvaluation.value!! && !restTwo()){
            _credits.value = (_credits.value)?.minus(2)
        }
        else if (preciseEvaluation.value!! && restTwo()){
            preciseEvaluation.value = false
            _noCreditsError.value = true
        }
        else{
            _credits.value = (_credits.value)?.plus(2)
        }
    }


    //métodos de validação de regra do crédito
    private fun restTwo(): Boolean {return (_credits.value!! < 2)}
    private fun restOne(): Boolean {return (_credits.value!! < 1)}
    private fun verifyMinTwo(): Boolean{return (_credits.value!!) > 8 || (_dexterity.value!!) == 7}
    private fun verifyMinLife(): Boolean{return (_credits.value!!) > 9 || (_life.value!!) == 20}
    private fun verifyMinBelief(): Boolean{return (_credits.value!!) > 9 || (_belief.value!!) == 7}



}