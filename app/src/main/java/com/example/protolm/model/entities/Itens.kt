package com.example.protolm.model.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itens")
data class Itens (

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "nome")
    @NonNull
    val nome: String,

    @ColumnInfo(name = "item_id")
    @NonNull
    val itemId: Int,

    @ColumnInfo(name = "efeito_id")
    @NonNull
    val efeitoId: Int,

    @ColumnInfo(name = "imagem_id")
    @NonNull
    val ImagemId: Int,

    @ColumnInfo(name = "equipado")
    @NonNull
    val equipado: Int
)