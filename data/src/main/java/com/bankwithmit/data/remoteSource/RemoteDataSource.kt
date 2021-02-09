package com.bankwithmit.data.remoteSource

import com.bankwithmit.data.remoteSource.response.CardInfoResponse
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getCardInfo(cardNumber: Int): Response<CardInfoResponse>
}