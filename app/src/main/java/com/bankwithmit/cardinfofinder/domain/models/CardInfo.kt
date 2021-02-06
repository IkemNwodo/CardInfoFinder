package com.bankwithmit.cardinfofinder.domain.models

data class CardInfo(
    val bank: String,
    val brand: String,
    val country: String,
    val type: String
)