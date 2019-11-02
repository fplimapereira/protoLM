package com.example.protolm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.protolm.databinding.CharacterFragmentBinding

import com.example.protolm.R
import com.example.protolm.viewmodel.CharacterViewModel
import com.example.protolm.factory.CharacterViewModelFactory
import com.example.protolm.repository.CharacterRepository
import com.example.protolm.view.CharacterFragmentDirections.Companion.actionCharacterFragmentToIntroFragment
import com.google.android.material.snackbar.Snackbar


class CharacterFragment : Fragment() {

    private lateinit var binding: CharacterFragmentBinding
    private lateinit var viewModel: CharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate(
            inflater, R.layout.character_fragment, container, false)

        val context = requireNotNull(this.activity).applicationContext
        val charRepo = CharacterRepository(context)
        val viewModelFactory = CharacterViewModelFactory(charRepo)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CharacterViewModel::class.java)

        binding.characterViewModel = viewModel
        binding.setLifecycleOwner(this)

        viewModel.noCreditsError.observe(this, Observer {
            if(it == true){
                Snackbar.make(
                    activity!!.findViewById(android.R.id.content),
                    getString(R.string.no_creds_msg),
                    Snackbar.LENGTH_SHORT
                ).show()
                viewModel.doneShowingSnackbar()
            }
        })

        viewModel.minimumValueError.observe(this, Observer {
            if(it == true){
                Snackbar.make(
                    activity!!.findViewById(android.R.id.content),
                    getString(R.string.min_val_msg),
                    Snackbar.LENGTH_SHORT
                ).show()
                viewModel.doneShowingSnackbar()
            }
        })

        viewModel.creditsLeftError.observe(this, Observer {
            if(it == true){
                Snackbar.make(
                    activity!!.findViewById(android.R.id.content),
                    getString(R.string.creds_unspent_msg),
                    Snackbar.LENGTH_SHORT
                ).show()
                viewModel.doneShowingSnackbar()
            }
        })

        viewModel.goToGame.observe(this, Observer {
            if(it == true){
                this.findNavController().navigate(actionCharacterFragmentToIntroFragment())
                viewModel.doneNavigating()
            }
        })


        return binding.root
    }


}
