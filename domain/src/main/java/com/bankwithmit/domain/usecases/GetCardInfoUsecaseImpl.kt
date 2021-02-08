package com.bankwithmit.domain.usecases

import com.bankwithmit.domain.repositories.CardRepository

class GetCardInfoUseCaseImpl(private val repository: CardRepository) : GetCardInfoUsecase {

    override suspend operator fun invoke(cardNumber: Int) =
        repository.getCardInfo(cardNumber)
}