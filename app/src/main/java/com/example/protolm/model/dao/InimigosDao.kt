package com.example.protolm.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.protolm.model.datamodels.Inimigos

@Dao
interface InimigosDao {

    @Query("SELECT * FROM  inimigos WHERE batalha_id = :batalhaId ")
    fun getBatalha(batalhaId: Int): Inimigos

}