package com.example.protolm.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inimigos")
data class Inimigos (

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "nome")
    @NonNull
    val nome: String,

    @ColumnInfo(name = "destreza")
    @NonNull
    val destreza: Int,

    @ColumnInfo(name = "vida")
    @NonNull
    val vida: Int,

    @ColumnInfo(name = "batalha_id")
    @NonNull
    val batalhaId: Int,

    @ColumnInfo(name = "habilidade_id")
    val habilidadeId: Int?,

    @ColumnInfo(name = "ponteiro_vitoria")
    @NonNull
    val ponteiroVitoria: Int,

    @ColumnInfo(name = "ponteiro_derrota")
    @NonNull
    val ponteiroDerrota: Int
)