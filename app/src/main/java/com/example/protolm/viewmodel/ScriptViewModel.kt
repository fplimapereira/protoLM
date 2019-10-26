package com.example.protolm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.protolm.model.entities.Eventos
import com.example.protolm.repository.ScriptRepository
import kotlinx.coroutines.*

class ScriptViewModel(val app: Application): AndroidViewModel(app) {

    private val job = Job()
    private var viewModelScope: CoroutineScope = CoroutineScope(Dispatchers.IO + job)
    private val repo: ScriptRepository = ScriptRepository(app)

    private var _enredo = MutableLiveData<Eventos>()
    val enredo: LiveData<Eventos>
        get() = _enredo

    private var ponteiro: Int? = 0



    fun getEvento(id: Int){
        viewModelScope.launch{
           // _enredo.postValue(repo.getEvento(id))
        }
    }

    fun getPonteiro(escolha: Int){
        when(escolha){
            1-> ponteiro = _enredo.value!!.pointeiroUm
            2-> ponteiro = _enredo.value!!.pointeiroDois
            3-> ponteiro = _enredo.value!!.pointeiroTres
            4-> ponteiro = _enredo.value!!.pointeiroQuatro
        }
    }

    fun tomarAcao(){
        if(ponteiro != null){
            getEvento(ponteiro!!)
        }
    }

    fun setEfeito(id: Int){

    }


}