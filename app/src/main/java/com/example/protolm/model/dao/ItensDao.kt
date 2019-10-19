package com.example.protolm.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.protolm.model.datamodels.Itens

@Dao
interface ItensDao {

    @Query("SELECT * FROM  itens WHERE item_id = :itemId ")
    fun getItens(itemId: Int): Itens

}