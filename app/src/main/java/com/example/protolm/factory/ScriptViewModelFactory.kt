package com.example.protolm.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.protolm.viewmodel.ScriptViewModel

class ScriptViewModelFactory (private val app: Application): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScriptViewModel::class.java)){
            return ScriptViewModel(app) as T
        }
        throw IllegalArgumentException("Unknow viewModel class")
    }
}