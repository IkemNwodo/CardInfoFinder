package com.bankwithmit.data.repositories

import com.bankwithmit.data.localSource.dao.CardInfoDao
import com.bankwithmit.data.localSource.entities.CardInfoEntity
import com.bankwithmit.data.mapper.CardInfoMapperRemoteSource
import com.bankwithmit.data.remoteSource.api.CardInfoService
import com.bankwithmit.domain.models.CardInfo
import com.bankwithmit.domain.repositories.CardRepository
import com.bankwithmit.domain.utils.Result

class CardRepositoryImpl(
    private val cardInfoService: CardInfoService,
    private val cardInfoDao: CardInfoDao
) : CardRepository {
    override suspend fun getCardInfo(cardNumber: Int): Result<CardInfo> {
        val cardInfoResult = cardInfoService.getCardInfo(cardNumber)
        return if (cardInfoResult.isSuccessful) {
            val mapperRemote = CardInfoMapperRemoteSource()
            val remoteData = cardInfoResult.body()
            if (remoteData != null) {
                cardInfoDao.saveCardInfo(
                    mapperRemote.mapperToCardInfo(remoteData)
                )
                Result.Success(mapperRemote.transform(remoteData))
            } else {
                Result.Success(null)
            }
        } else {
            Result.Error(Exception("Invalid data/failure"))
        }
    }

    override suspend fun getSavedCards(): Result<List<CardInfo>> {
        TODO("Not yet implemented")
    }
}