package com.example.protolm.di

import com.example.protolm.model.entities.Character
import dagger.Component

@Component(modules = [CharModule::class])
interface CharComponent{
    fun injectChar(): Character
}

