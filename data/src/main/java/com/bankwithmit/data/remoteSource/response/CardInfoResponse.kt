package com.bankwithmit.data.remoteSource.response

import com.bankwithmit.data.localSource.entities.CardInfoEntity

data class CardInfoResponse(
    val bank: Bank?,
    val brand: String? = "",
    val country: Country?,
    val type: String? = ""
)

data class Bank(
    val name: String? = ""
)

data class Country(
    val name: String? = ""
)

fun CardInfoResponse.toEntity() =
    CardInfoEntity(bank = bank, country = country, type = type, brand = brand)