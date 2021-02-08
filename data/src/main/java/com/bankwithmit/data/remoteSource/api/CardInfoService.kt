package com.bankwithmit.data.remoteSource.api

import com.bankwithmit.data.remoteSource.response.CardInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CardInfoService {
    @GET("{cardNumber}")
    suspend fun getCardInfo(@Path("cardNumber") cardNumber: Int): Response<CardInfoResponse>

}