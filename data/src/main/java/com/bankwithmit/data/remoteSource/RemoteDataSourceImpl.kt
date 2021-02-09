package com.bankwithmit.data.remoteSource

import com.bankwithmit.data.remoteSource.api.CardInfoService
import com.bankwithmit.data.remoteSource.response.CardInfoResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val cardInfoService: CardInfoService) : RemoteDataSource {
    override suspend fun getCardInfo(cardNumber: Int): Response<CardInfoResponse> {
        return cardInfoService.getCardInfo(cardNumber)
    }
}