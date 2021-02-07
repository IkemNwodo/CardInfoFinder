package com.bankwithmit.domain.usecases

import com.bankwithmit.domain.models.CardInfo
import com.bankwithmit.domain.utils.Result

interface GetCardInfoUsecase {
    suspend operator fun invoke(cardNumber: Int): com.bankwithmit.domain.utils.Result<com.bankwithmit.domain.models.CardInfo>
}