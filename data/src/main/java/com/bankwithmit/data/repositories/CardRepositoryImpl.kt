package com.bankwithmit.data.repositories

import com.bankwithmit.data.coroutines.DispatcherProvider
import com.bankwithmit.data.localSource.dao.CardInfoDao
import com.bankwithmit.data.mapper.CardInfoMapperRemoteSource
import com.bankwithmit.data.remoteSource.api.CardInfoService
import com.bankwithmit.domain.models.CardInfo
import com.bankwithmit.domain.repositories.CardRepository
import com.bankwithmit.domain.utils.Result
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val cardInfoService: CardInfoService,
    private val cardInfoDao: CardInfoDao,
    private val dispatchers: DispatcherProvider
) : CardRepository {
    override suspend fun getCardInfo(cardNumber: Int): Result<CardInfo> =  withContext(dispatchers.io()){
        val cardInfoResult = cardInfoService.getCardInfo(cardNumber)
        return@withContext if (cardInfoResult.isSuccessful) {
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