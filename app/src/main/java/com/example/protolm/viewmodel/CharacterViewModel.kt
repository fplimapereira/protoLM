package com.example.protolm.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.protolm.di.CharComponent
import com.example.protolm.di.DaggerCharComponent
import com.example.protolm.model.entities.Character
import com.example.protolm.repository.ScriptRepository

class CharacterViewModel(val app: Application): ViewModel() {

    var personagem: Character

    val dagger: CharComponent = DaggerCharComponent.create()

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

    private val _minimumValueError = MutableLiveData<Boolean>()
    val minimumValueError: LiveData<Boolean>
        get() = _minimumValueError

    private val _creditsLeftError = MutableLiveData<Boolean>()
    val creditsLeftError: LiveData<Boolean>
        get() = _creditsLeftError

    //propriedade de navegação
    val goToGame = MutableLiveData<Boolean>()

    // Objeto repositório personagem
    val repo: ScriptRepository =
        ScriptRepository(app)



    //inicializando a VM
    init {
        personagem = dagger.injectChar()
        _credits.value = personagem.credits
        _dexterity.value = personagem.dext
        _life.value = personagem.life
        _belief.value = personagem.belief
        criticalAttack.value = personagem.critAttack
        preciseEvaluation.value = personagem.preVal
        fastRegen.value = personagem.fastRegen
        _noCreditsError.value = false
        _minimumValueError.value = false
        _creditsLeftError.value = false
        goToGame.value = false
    }

    //métodos para os botões

    //adiciona destreza
    fun addDex(){
        if(personagem.addDextery(_credits.value!!)){
            _noCreditsError.value = true
        }
        else{
            _credits.value = (_credits.value)?.minus(2)
            _dexterity.value = (_dexterity.value)?.plus(1)
        }
    }

    //remove destreza
    fun removeDex(){
        if(personagem.removeDexterity(_credits.value!!, _dexterity.value!!)){
            _minimumValueError.value = true
        }
        else{
            _credits.value = (_credits.value)?.plus(2)
            _dexterity.value = (_dexterity.value)?.minus(1)
        }
    }

    //adiciona vida
    fun addLife(){
        if(personagem.addLife(_credits.value!!)){
            _noCreditsError.value = true
        }
        else{
            _credits.value = (_credits.value)?.minus(1)
            _life.value = (_life.value)?.plus(2)
        }
    }

    //remove vida
    fun removeLife(){
        if(personagem.removeLife(_credits.value!!, _life.value!!)){
            _minimumValueError.value = true
        }
        else{
            _credits.value = (_credits.value)?.plus(1)
            _life.value = (_life.value)?.minus(2)
        }
    }

    //adiciona convicção
    fun addBelief(){
        if(personagem.addBelief(_credits.value!!)){
            _noCreditsError.value = true
        }
        else{
            _credits.value = (_credits.value)?.minus(1)
            _belief.value = (_belief.value)?.plus(1)
        }
    }

    //remove convicção
    fun removeBelief(){
        if(personagem.removeBelief(_credits.value!!, _belief.value!!)){
            _minimumValueError.value = true
        }
        else{
            _credits.value = (_credits.value)?.plus(1)
            _belief.value = (_belief.value)?.minus(1)
        }
    }


    //adiciona e remove Ataque Poderoso
    fun addCrtAttk(){
        when (personagem.verifySkill(criticalAttack.value!!, _credits.value!!)){
            1-> _credits.value = (_credits.value)?.minus(2)
            2-> {
                criticalAttack.value = false
                _noCreditsError.value = true
            }
            3-> _credits.value = (_credits.value)?.plus(2)
        }
    }

    //adiciona e remove Regeneração Acelerada
    fun addFastRegen(){
        when (personagem.verifySkill(fastRegen.value!!, _credits.value!!)){
            1-> _credits.value = (_credits.value)?.minus(2)
            2-> {
                fastRegen.value = false
                _noCreditsError.value = true
            }
            3-> _credits.value = (_credits.value)?.plus(2)
        }
    }

    //adiciona e remove Avaliação Precisa
    fun addPreciseEvaluation(){
        when (personagem.verifySkill(preciseEvaluation.value!!, _credits.value!!)){
            1-> _credits.value = (_credits.value)?.minus(2)
            2-> {
                preciseEvaluation.value = false
                _noCreditsError.value = true
            }
            3-> _credits.value = (_credits.value)?.plus(2)
        }
    }


    //métodos de validação de regra do crédito
    private fun restTwo(): Boolean {return (_credits.value!! < 2)}


    fun saveChar(){
        if(_credits.value!! > 0){
            _creditsLeftError.value = true
        }
        else{

            goToGame.value = true
        }
    }

    fun doneShowingSnackbar() {
        _noCreditsError.value = false
        _minimumValueError.value = false
        _creditsLeftError.value = false
    }

}