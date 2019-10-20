package com.example.protolm.di

import dagger.Module
import dagger.Provides
import com.example.protolm.model.entities.Character

@Module
class CharModule {

    @Provides
    fun provideCharacter(): Character {
        var personagem = Character(7, 20,7, false, false, false, 10)
        return personagem
    }
}