package com.bankwithmit.data.localSource

import com.bankwithmit.data.localSource.entities.CardInfoEntity

interface LocalDataSource {
    suspend fun saveCardInfo(cardInfoEntity: CardInfoEntity)
    suspend fun getAllCardInfo():List<CardInfoEntity>?
}