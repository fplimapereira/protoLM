package com.example.protolm.title


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.protolm.R
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.protolm.databinding.TitleFragmentBinding


class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding : TitleFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.title_fragment, container, false)

        binding.btStartGame.setOnClickListener {
            it.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToCharacterFragment())
        }

        return binding.root
        }

}



