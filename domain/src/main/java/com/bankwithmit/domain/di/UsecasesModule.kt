package com.bankwithmit.domain.di

import com.bankwithmit.domain.usecases.GetCardInfoUseCaseImpl
import com.bankwithmit.domain.usecases.GetCardInfoUsecase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UsecasesModule {

    @Binds
    abstract fun bindsGetCardInfoUsecase(getCardInfoUseCaseImpl: GetCardInfoUseCaseImpl): GetCardInfoUsecase
}