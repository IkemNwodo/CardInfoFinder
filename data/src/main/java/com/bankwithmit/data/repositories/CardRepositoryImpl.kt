package com.bankwithmit.data.repositories

import com.bankwithmit.data.coroutines.DispatcherProvider
import com.bankwithmit.data.localSource.LocalDataSource
import com.bankwithmit.data.mapper.CardInfoMapperRemoteSource
import com.bankwithmit.data.remoteSource.RemoteDataSource
import com.bankwithmit.domain.models.CardInfo
import com.bankwithmit.domain.repositories.CardRepository
import com.bankwithmit.domain.utils.Result
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val dispatchers: DispatcherProvider
) : CardRepository {
    override suspend fun getCardInfo(cardNumber: Int): com.bankwithmit.domain.utils.Result<CardInfo> =  withContext(dispatchers.io()){
        val cardInfoResult = remoteDataSource.getCardInfo(cardNumber)
        return@withContext if (cardInfoResult.isSuccessful) {
            val mapperRemote = CardInfoMapperRemoteSource()
            val remoteData = cardInfoResult.body()
            if (remoteData != null) {
                localDataSource.saveCardInfo(
                    mapperRemote.mapperToCardInfo(remoteData)
                )
                com.bankwithmit.domain.utils.Result.Success(mapperRemote.transform(remoteData))
            } else {
                com.bankwithmit.domain.utils.Result.Success(null)
            }
        } else {
            com.bankwithmit.domain.utils.Result.Error(Exception("Invalid data/failure"))
        }
    }

    override suspend fun getSavedCards(): com.bankwithmit.domain.utils.Result<List<CardInfo>> {
        TODO("Not yet implemented")
    }
}