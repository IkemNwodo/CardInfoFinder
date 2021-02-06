package com.bankwithmit.cardinfofinder.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bankwithmit.cardinfofinder.R
import com.bankwithmit.cardinfofinder.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.inputTouchView.setOnClickListener {
            val action = HomeFragmentDirections.actionNavigationHomeToNavigationInput()
            findNavController().navigate(action)
        }

        binding.ocrTouchView.setOnClickListener {
            val action = HomeFragmentDirections.actionNavigationHomeToNavigationOcr()
            findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}