package com.example.protolm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.protolm.repository.CharacterRepository
import com.example.protolm.viewmodel.TestViewModel

class TestViewModelFactory (private val id: Int, private val charRepo: CharacterRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TestViewModel::class.java)){
            return TestViewModel(id, charRepo) as T
        }
        throw IllegalArgumentException("Unknow viewModel class")
    }

}