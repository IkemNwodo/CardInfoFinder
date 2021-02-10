package com.bankwithmit.data.di

import com.bankwithmit.data.localSource.LocalDataSource
import com.bankwithmit.data.localSource.LocalDataSourceImpl
import com.bankwithmit.data.localSource.dao.CardInfoDao
import com.bankwithmit.data.remoteSource.RemoteDataSource
import com.bankwithmit.data.remoteSource.RemoteDataSourceImpl
import com.bankwithmit.data.remoteSource.api.CardInfoService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(cardInfoDao: CardInfoDao): LocalDataSource {
        return LocalDataSourceImpl(cardInfoDao)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(cardInfoService: CardInfoService): RemoteDataSource {
        return RemoteDataSourceImpl(cardInfoService)
    }
}