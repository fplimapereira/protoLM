package com.example.protolm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.protolm.R
import com.example.protolm.factory.ScriptViewModelFactory
import com.example.protolm.factory.SwitcherFactory
import com.example.protolm.viewmodel.ScriptViewModel
import com.example.protolm.databinding.FragmentScriptBinding
import com.example.protolm.databinding.BattleDrawerBinding

class ScriptFragment: Fragment() {

    lateinit var binding: FragmentScriptBinding
    lateinit var drawerBinding: BattleDrawerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_script, container, false)
        drawerBinding = DataBindingUtil.inflate(inflater, R.layout.battle_drawer, container, false)
        binding.scriptFragment.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        val application = requireNotNull(this.activity).application
        val viewModelFactory = ScriptViewModelFactory(application)
        val scriptViewModel = ViewModelProviders.of(this, viewModelFactory).get(ScriptViewModel::class.java)
        binding.tvSwitch.setFactory {  SwitcherFactory(application).makeView() }
        scriptViewModel.getEvento(1)
        binding.viewModel = scriptViewModel
        scriptViewModel.enredo.observe(this, Observer {
            binding.tvSwitch.setText(it.evento)

            if(it.acaoUm != null){
                binding.radioButton.visibility = View.VISIBLE
                binding.radioButton.text = it.acaoUm

            }
            else{binding.radioButton.visibility = View.GONE}

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

            if (it.efeitoId != null) binding.viewModel?.setEfeito(it.efeitoId)
            if (it.itemId != null) binding.viewModel?.setIten(it.itemId)
            if (it.testeId != null){
                this.findNavController().navigate(ScriptFragmentDirections.actionScriptFragmentToTestDialog(it.testeId))
            }

        })

        return binding.root
    }
}




