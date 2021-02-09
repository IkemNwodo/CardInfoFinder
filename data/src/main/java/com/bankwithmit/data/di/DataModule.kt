package com.bankwithmit.data.di

import com.bankwithmit.data.localSource.LocalDataSource
import com.bankwithmit.data.localSource.LocalDataSourceImpl
import com.bankwithmit.data.remoteSource.RemoteDataSource
import com.bankwithmit.data.remoteSource.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}