package com.bankwithmit.cardinfofinder.ui.ocr

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cards.pay.paycardsrecognizer.sdk.Card
import cards.pay.paycardsrecognizer.sdk.ScanCardIntent
import com.bankwithmit.cardinfofinder.R
import com.bankwithmit.cardinfofinder.databinding.FragmentOCRBinding
import com.bankwithmit.cardinfofinder.ui.inputfield.InputFragmentDirections
import com.google.android.material.snackbar.Snackbar


class OCRFragment : Fragment() {

    private var _binding: FragmentOCRBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val REQUEST_CODE_SCAN_CARD = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOCRBinding.inflate(inflater, container, false)

        binding.scanBtn.setOnClickListener { scanCard() }
        binding.checkBtn.setOnClickListener { navigate() }

        return binding.root
    }

    private fun navigate() {
        val cardNumber = binding.cardNumberField.text.toString()
        val action = OCRFragmentDirections.actionNavigationOcrToNavigationResult(cardNumber)
        findNavController().navigate(action)
    }

    private fun scanCard() {
        val intent = ScanCardIntent.Builder(context).build()
        startActivityForResult(intent, REQUEST_CODE_SCAN_CARD)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_SCAN_CARD) {
            if (resultCode == Activity.RESULT_OK) {
                showHideViews(true)
                val card: Card = data?.getParcelableExtra(ScanCardIntent.RESULT_PAYCARDS_CARD)!!
                handleCardNumber(card.cardNumberRedacted)
            } else if (resultCode == Activity.RESULT_CANCELED) {
                showHideViews(false)
                snackBar(getString(R.string.scan_canceled))
            } else {
                showHideViews(false)
                snackBar(getString(R.string.scan_failed))
            }
        }
    }

    private fun handleCardNumber(cardNumber: String?) {
        binding.cardNumberField.setText(cardNumber)
    }

    private fun showHideViews(isSuccessful: Boolean) {
        if (isSuccessful){
            binding.scanBtn.isVisible = false
            binding.cardNumberLayout.isVisible = true
            binding.checkBtn.isVisible = true
        } else {
            binding.scanBtn.isVisible = true
            binding.cardNumberLayout.isVisible = false
            binding.checkBtn.isVisible = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun snackBar(message: String) {
        Snackbar.make(binding.mycoorinatoLayout, message, Snackbar.LENGTH_LONG).show()
    }
}