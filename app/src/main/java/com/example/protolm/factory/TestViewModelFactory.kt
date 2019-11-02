package com.example.protolm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.protolm.viewmodel.TestViewModel

class TestViewModelFactory (private val id: Int): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TestViewModel::class.java)){
            return TestViewModel(id) as T
        }
        throw IllegalArgumentException("Unknow viewModel class")
    }

}