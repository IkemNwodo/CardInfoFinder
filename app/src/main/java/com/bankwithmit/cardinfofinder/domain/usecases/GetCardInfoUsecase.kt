package com.bankwithmit.cardinfofinder.domain.usecases

import com.bankwithmit.cardinfofinder.domain.models.CardInfo
import com.bankwithmit.cardinfofinder.domain.utils.Result

interface GetCardInfoUsecase {
    suspend operator fun invoke(cardNumber: Int): Result<CardInfo>
}