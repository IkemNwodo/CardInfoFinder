package com.bankwithmit.cardinfofinder.ui.inputfield

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.bankwithmit.cardinfofinder.R
import com.bankwithmit.cardinfofinder.databinding.FragmentHomeBinding
import com.bankwithmit.cardinfofinder.databinding.FragmentInputBinding
import com.bankwithmit.cardinfofinder.ui.home.HomeFragmentDirections


class InputFragment : Fragment() {

    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInputBinding.inflate(inflater, container, false)

        binding.checkBtn .setOnClickListener {
            navigate()
        }

        binding.cardNumberField.doOnTextChanged {_, _, _, _, -> binding.cardNumberLayout.run { error = "" }}
        return binding.root
    }

    private fun navigate() {
        val cardNumber = binding.cardNumberField.text.toString()
        if (cardNumber.isNotEmpty()){
            val action = InputFragmentDirections.actionNavigationInputToNavigationResult(cardNumber)
            findNavController().navigate(action)
        } else {
            binding.cardNumberLayout.error = "Must enter card Number"
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}