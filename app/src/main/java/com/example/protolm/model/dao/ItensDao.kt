package com.example.protolm.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.protolm.model.entities.Itens

@Dao
interface ItensDao {

    @Query("SELECT * FROM  itens WHERE item_id = :itemId ")
    fun getItens(itemId: Int): Itens

    @Update
    fun updateItem(item: Itens)

}