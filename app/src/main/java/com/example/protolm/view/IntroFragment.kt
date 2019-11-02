package com.example.protolm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.protolm.R
import com.example.protolm.databinding.IntroFragmentBinding
import com.example.protolm.view.IntroFragmentDirections.Companion.actionIntroFragmentToScriptFragment


class IntroFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding : IntroFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.intro_fragment, container, false)

        binding.button.setOnClickListener {
            it.findNavController().navigate(actionIntroFragmentToScriptFragment())
        }

        return binding.root
    }


}
