package com.example.protolm.character


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.protolm.databinding.CharacterFragmentBinding

import com.example.protolm.R
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

        viewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java)

        binding.characterViewModel = viewModel
        binding.setLifecycleOwner(this)

        viewModel.noCreditsError.observe(this, Observer {
            if(it == true){
                Snackbar.make(
                    activity!!.findViewById(android.R.id.content),
                    getString(R.string.no_creds_msg),
                    Snackbar.LENGTH_SHORT // How long to display the message.
                ).show()
            }
        })

        viewModel.minimumValueError.observe(this, Observer {
            if(it == true){
                Snackbar.make(
                    activity!!.findViewById(android.R.id.content),
                    getString(R.string.min_val_msg),
                    Snackbar.LENGTH_SHORT // How long to display the message.
                ).show()
            }
        })

        viewModel.creditsLeftError.observe(this, Observer {
            if(it == true){
                Snackbar.make(
                    activity!!.findViewById(android.R.id.content),
                    getString(R.string.creds_unspent_msg),
                    Snackbar.LENGTH_SHORT // How long to display the message.
                ).show()
            }
        })
        return binding.root
    }


}
