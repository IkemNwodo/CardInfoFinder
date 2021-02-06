package com.bankwithmit.cardinfofinder.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bankwithmit.cardinfofinder.R
import com.bankwithmit.cardinfofinder.databinding.FragmentHomeBinding

class HistoryFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private lateinit var notificationsViewModel: HistoryViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(HistoryViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
