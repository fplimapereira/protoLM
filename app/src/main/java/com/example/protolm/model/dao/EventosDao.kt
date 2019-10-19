package com.example.protolm.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.protolm.model.entities.Eventos

@Dao
interface EventosDao {

    @Insert
    fun insertEvento(e: Eventos)

    @Query("SELECT * FROM eventos WHERE ponteiro = :id ")
    fun getScript(id: Int): Eventos

}