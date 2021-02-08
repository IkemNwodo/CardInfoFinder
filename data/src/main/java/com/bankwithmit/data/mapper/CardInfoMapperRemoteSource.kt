package com.bankwithmit.data.mapper

import com.bankwithmit.data.localSource.entities.CardInfoEntity
import com.bankwithmit.data.remoteSource.response.Bank
import com.bankwithmit.data.remoteSource.response.CardInfoResponse
import com.bankwithmit.data.remoteSource.response.Country
import com.bankwithmit.domain.models.CardInfo

class CardInfoMapperRemoteSource : BaseMapper<CardInfoResponse, CardInfo> {
    override fun transform(type: CardInfoResponse): CardInfo = CardInfo(
        type.bank?.name ?: "", type.brand ?: "", type.country?.name ?: "", type.type ?: ""
    )

    fun mapperToCardInfo(type: CardInfoResponse): CardInfoEntity = CardInfoEntity(
        bank = type.bank, brand = type.brand, country = type.country
    )
}