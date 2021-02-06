package com.bankwithmit.cardinfofinder

import android.widget.TextView

    fun TextView.getText(text: String) {
        val initialText = this.text.toString()
        this.text = String.format(initialText, text)
    }