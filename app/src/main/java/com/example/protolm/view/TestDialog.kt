package com.example.protolm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.example.protolm.R
import com.example.protolm.databinding.TestDialogBinding
import com.example.protolm.factory.TestViewModelFactory
import com.example.protolm.viewmodel.TestViewModel


class TestDialog : DialogFragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: TestDialogBinding = DataBindingUtil.inflate(
            inflater, R.layout.test_dialog, container, false)

        var bundle = ScriptFragmentDirections.actionScriptFragmentToTestDialog().arguments
        val viewModelFactory = TestViewModelFactory(bundle.getInt("testId"))
        val testViewModel = ViewModelProviders.of(this, viewModelFactory).get(TestViewModel::class.java)


        return binding.root
    }
    
}