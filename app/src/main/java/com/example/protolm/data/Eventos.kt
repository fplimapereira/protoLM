package com.example.protolm.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "eventos")
data class Eventos (

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo(name = "evento")
    @NonNull
    var evento: String,

    @ColumnInfo(name="acao_um")
    @NonNull
    var acaoUm: String,

    @ColumnInfo(name="acao_dois")
    var acaoDois: String?,

    @ColumnInfo(name="acao_tres")
    var acaoTres: String?,

    @ColumnInfo(name="acao_quatro")
    var acaoQuatro: String?,

    @ColumnInfo(name="ponteiro_um")
    var pointeiroUm: Int?,

    @ColumnInfo(name="ponteiro_dois")
    var pointeiroDois: Int?,

    @ColumnInfo(name="ponteiro_tres")
    var pointeiroTres: Int?,

    @ColumnInfo(name="ponteiro_quatro")
    var pointeiroQuatro: Int?,

    @ColumnInfo(name="item_id")
    val itemId: Int?,

    @ColumnInfo(name="batalha_id")
    val batalhaId: Int?,

    @ColumnInfo(name="teste_id")
    val testeId: Int?,

    @ColumnInfo(name="ponteiro")
    val ponteiro: Int?,

    @ColumnInfo(name="efeito_id")
    val efeitoId: Int?
)