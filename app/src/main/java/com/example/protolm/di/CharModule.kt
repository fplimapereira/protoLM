package com.example.protolm.di

import dagger.Module
import dagger.Provides
import com.example.protolm.model.entities.Character

@Module
class CharModule {

    @Provides
    fun provideCharacter(): Character {
        var personagem = Character(7, 0,20, 0, 7, 0, false, false, false, 10)
        return personagem
    }
}