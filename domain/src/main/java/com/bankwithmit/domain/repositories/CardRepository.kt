package com.bankwithmit.domain.repositories

import com.bankwithmit.domain.models.CardInfo
import com.bankwithmit.domain.utils.Result

interface CardRepository {
    suspend fun getCardInfo(cardNumber: Int): Result<CardInfo>
    suspend fun getSavedCards(): Result<List<CardInfo>>
}