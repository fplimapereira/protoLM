package com.example.protolm.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.protolm.dao.EventosDao
import com.example.protolm.dao.InimigosDao
import com.example.protolm.dao.ItensDao
import com.example.protolm.model.entities.Eventos
import com.example.protolm.model.entities.Inimigos
import com.example.protolm.model.entities.Itens

@Database(entities = [Eventos::class, Inimigos::class, Itens::class], version = 2)
abstract class ScriptDataBase : RoomDatabase(){

    abstract fun eventosDao(): EventosDao
    abstract fun inimigosDao(): InimigosDao
    abstract fun itensDao(): ItensDao

    companion object {
        @Volatile
        private var INSTANCE: ScriptDataBase? = null

        fun getInstance (context: Context): ScriptDataBase{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,
                        ScriptDataBase::class.java, "bancolm")
                        .fallbackToDestructiveMigration()
                        .createFromAsset("bancolm.db")
                        .build()
                        INSTANCE = instance
                }
                return instance
            }
        }
    }
}