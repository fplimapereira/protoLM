package com.example.protolm.repository

import android.app.Application
import com.example.protolm.dao.EventosDao
import com.example.protolm.dao.InimigosDao
import com.example.protolm.dao.ItensDao
import com.example.protolm.model.ScriptDataBase
import com.example.protolm.model.entities.Eventos
import com.example.protolm.model.entities.Itens


class ScriptRepository(val app: Application){

    private val eventoDao: EventosDao = ScriptDataBase.getInstance(app).eventosDao()
    private val itemDao: ItensDao = ScriptDataBase.getInstance(app).itensDao()
    private val inimigosDao: InimigosDao = ScriptDataBase.getInstance(app).inimigosDao()


    fun getEvento(id: Int): Eventos? = eventoDao.getScript(id)

    fun updateItem(item: Itens) = itemDao.updateItem(item)

}