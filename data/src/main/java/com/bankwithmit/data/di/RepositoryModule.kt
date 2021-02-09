package com.bankwithmit.data.di

import com.bankwithmit.data.coroutines.DefaultDispatcherProvider
import com.bankwithmit.data.coroutines.DispatcherProvider
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
 abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun providesCardInfoRepository(cardRepositoryImpl: CardRepositoryImpl): CardRepository

    @Provides
    @Singleton
    abstract fun provideDispatcherProvider(defaultDispatcherProvider: DefaultDispatcherProvider): DispatcherProvider

}