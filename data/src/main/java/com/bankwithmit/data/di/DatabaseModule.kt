package com.bankwithmit.data.di

import android.app.Application
import androidx.room.Room
import com.bankwithmit.data.CardInfoDatabase
import com.bankwithmit.data.localSource.dao.CardInfoDao
import com.bankwithmit.data.utils.Constants.CARD_INFO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesCardInfoDatabase(application: Application): CardInfoDatabase {
        return Room
            .databaseBuilder(application, CardInfoDatabase::class.java, CARD_INFO_DATABASE)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesCardInfoDao(cardInfoDatabase: CardInfoDatabase): CardInfoDao {
        return cardInfoDatabase.cardInfoDao
    }
}