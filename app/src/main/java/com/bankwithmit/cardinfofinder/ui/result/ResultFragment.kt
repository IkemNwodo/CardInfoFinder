package com.bankwithmit.cardinfofinder.ui.result

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bankwithmit.cardinfofinder.R
import com.bankwithmit.cardinfofinder.databinding.FragmentOCRBinding
import com.bankwithmit.cardinfofinder.databinding.ResultFragmentBinding
import com.bankwithmit.cardinfofinder.getText
import com.google.android.material.snackbar.Snackbar

class ResultFragment : Fragment() {

    private var _binding: ResultFragmentBinding? = null
    private val binding get() = _binding!!

    private val args: ResultFragmentArgs by navArgs()
    private val viewModel: ResultViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ResultFragmentBinding.inflate(inflater, container, false)

        viewModel.getCardNumber(args.cardNumber.toInt())
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.cardInfo.observe(viewLifecycleOwner, Observer { cardInfo ->
            if (cardInfo != null) {
                with(binding){
                    cardLayout.isVisible = true
                    cardBrand.getText(cardInfo.brand)
                    cardType.getText(cardInfo.type)
                    bank.getText(cardInfo.bank)
                    country.getText(cardInfo.country)
                }
            }
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer { loading ->
            if (!loading) binding.progressBar.isVisible = false
        })

        viewModel.isSuccessful.observe(viewLifecycleOwner, Observer { successful ->
            if (!successful) {
                with(binding){
                    progressBar.isVisible = false
                    cardLayout.isVisible = false
                    errorText.isVisible = true
                }
                Snackbar.make(requireView(), getString(R.string.snack_message),
                    Snackbar.LENGTH_LONG).setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
                    .show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}