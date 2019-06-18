package com.example.protolm.character


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.protolm.databinding.CharacterFragmentBinding

import com.example.protolm.R



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

        return binding.root
    }


}
