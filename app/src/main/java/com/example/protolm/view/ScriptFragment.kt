package com.example.protolm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.protolm.R
import com.example.protolm.factory.ScriptViewModelFactory
import com.example.protolm.factory.SwitcherFactory
import com.example.protolm.viewmodel.ScriptViewModel
import com.example.protolm.databinding.ScriptFragmentBinding


class ScriptFragment: Fragment() {

    lateinit var binding: ScriptFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_script, container, false)

        val application = requireNotNull(this.activity).application
        val viewModelFactory = ScriptViewModelFactory(application)
        val scriptViewModel = ViewModelProviders.of(this, viewModelFactory).get(ScriptViewModel::class.java)
        binding.tvSwitch.setFactory {  SwitcherFactory(application).makeView() }
        scriptViewModel.getEvento(1)
        binding.viewModel = scriptViewModel
        scriptViewModel.enredo.observe(this, Observer {
            binding.tvSwitch.setText(it.evento)
            binding.radioButton.text = it.acaoUm
            binding.radioButton.isChecked = false

            if(it.acaoDois != null){
                binding.radioButton2.visibility = View.VISIBLE
                binding.radioButton2.text = it.acaoDois
                binding.radioButton2.isChecked = false
            }
            else{binding.radioButton2.visibility = View.GONE}

            if(it.acaoTres != null){
                binding.radioButton3.visibility = View.VISIBLE
                binding.radioButton3.text = it.acaoTres
                binding.radioButton3.isChecked = false
            }
            else{binding.radioButton3.visibility = View.GONE}

            if(it.acaoQuatro != null){
                binding.radioButton4.visibility = View.VISIBLE
                binding.radioButton4.text = it.acaoQuatro
                binding.radioButton4.isChecked = false
            }
            else{binding.radioButton4.visibility = View.GONE}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //it.efeitoId?.let { binding.viewModel. }

        })

        return binding.root
    }
}




