package com.example.protolm.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.protolm.repository.CharacterRepository
import com.example.protolm.viewmodel.CharacterViewModel

class CharacterViewModelFactory(private val charRepo: CharacterRepository): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterViewModel::class.java)){
            return CharacterViewModel(charRepo) as T
        }
        throw IllegalArgumentException("Unknow viewModel class")
    }
}