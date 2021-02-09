package com.bankwithmit.data.localSource

import com.bankwithmit.data.localSource.dao.CardInfoDao
import com.bankwithmit.data.localSource.entities.CardInfoEntity
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val cardInfoDao: CardInfoDao) : LocalDataSource {
    override suspend fun saveCardInfo(cardInfoEntity: CardInfoEntity) {
        cardInfoDao.saveCardInfo(cardInfoEntity)
    }

    override suspend fun getAllCardInfo(): List<CardInfoEntity>? {
       return cardInfoDao.getAllCardInfo()
    }
}