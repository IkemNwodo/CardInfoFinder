package com.bankwithmit.data.mapper

import com.bankwithmit.data.localSource.entities.CardInfoEntity
import com.bankwithmit.domain.models.CardInfo

class CardInfoMapperLocalSource : BaseMapper<CardInfoEntity, CardInfo> {
    override fun transform(type: CardInfoEntity): CardInfo = CardInfo(
        bank = type.bank?.name ?: "", brand = type.brand ?: "", country = type.country?.name ?: "", type = type.type ?: ""
    )
}