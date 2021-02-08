package com.bankwithmit.data.di

import com.bankwithmit.data.repositories.CardRepositoryImpl
import com.bankwithmit.domain.repositories.CardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
 abstract class RepositoryModule {

    @Binds
    abstract fun bindsCardInfoRepository(cardRepositoryImpl: CardRepositoryImpl): CardRepository
}