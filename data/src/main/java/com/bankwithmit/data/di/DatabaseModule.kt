package com.bankwithmit.data.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.bankwithmit.data.CardInfoDatabase
import com.bankwithmit.data.localSource.dao.CardInfoDao
import com.bankwithmit.data.utils.Constants.CARD_INFO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideCardInfoDatabase(@ApplicationContext appContext: Context): CardInfoDatabase {
        return Room
            .databaseBuilder(appContext, CardInfoDatabase::class.java, CARD_INFO_DATABASE)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideCardInfoDao(cardInfoDatabase: CardInfoDatabase): CardInfoDao {
        return cardInfoDatabase.cardInfoDao
    }
}