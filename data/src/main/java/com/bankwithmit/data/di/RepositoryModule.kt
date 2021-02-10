package com.bankwithmit.data.di

import com.bankwithmit.data.coroutines.DefaultDispatcherProvider
import com.bankwithmit.data.coroutines.DispatcherProvider
import com.bankwithmit.data.localSource.LocalDataSource
import com.bankwithmit.data.remoteSource.RemoteDataSource
import com.bankwithmit.data.repositories.CardRepositoryImpl
import com.bankwithmit.domain.repositories.CardRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 object RepositoryModule {

    @Singleton
    @Provides
    fun provideCardInfoRepository(remoteDataSource: RemoteDataSource,
    localDataSource: LocalDataSource, dispatcherProvider: DispatcherProvider): CardRepository{
       return CardRepositoryImpl(remoteDataSource, localDataSource, dispatcherProvider)
    }

    @Singleton
    @Provides
    fun provideDispatcherProvider(): DispatcherProvider = DefaultDispatcherProvider()

}