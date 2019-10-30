package com.example.protolm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.protolm.model.entities.Character
import com.example.protolm.model.entities.Eventos
import com.example.protolm.model.entities.Itens
import com.example.protolm.repository.CharacterRepository
import com.example.protolm.repository.ScriptRepository
import kotlinx.coroutines.*

class ScriptViewModel(val app: Application): AndroidViewModel(app) {

    private val job = Job()
    private var viewModelScope: CoroutineScope = CoroutineScope(Dispatchers.IO + job)
    private val repo: ScriptRepository = ScriptRepository(app)
    private val charRepo: CharacterRepository = CharacterRepository(app)
    private lateinit var item :Itens

    private var _enredo = MutableLiveData<Eventos>()
    val enredo: LiveData<Eventos>
        get() = _enredo

    private var ponteiro: Int? = 0



    fun getEvento(id: Int){
        viewModelScope.launch{
            _enredo.postValue(repo.getEvento(id))
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
        charRepo.imputEffect(id)

    }

    fun setIten(id: Int){
        when(id){
            1->item = Itens(1,"Maçã azul", 1, 1, 1)
            2->item = Itens(2,"Recipiente com vermes", 2, 2, 1)
            3->item = Itens(3,"Amuledo de jade", 3, 3, 1)
            4->item = Itens(4,"Chave de ferro", 4, 4, 1)
            5->item = Itens(5,"Pergaminho", 5, 5, 1)
            6->item = Itens(6,"Poção de cura", 6, 6, 1)
            7->item = Itens(7,"Poção de ácido", 7, 7, 1)
            8->item = Itens(8,"Espada mágica", 1, 1, 1)
        }
        viewModelScope.launch{
            repo.updateItem(item)
        }
    }



}