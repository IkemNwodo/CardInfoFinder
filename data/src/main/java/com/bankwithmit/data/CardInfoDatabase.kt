package com.bankwithmit.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bankwithmit.data.localSource.dao.CardInfoDao
import com.bankwithmit.data.localSource.entities.CardInfoEntity
import com.bankwithmit.data.typeConverter.Converters

@Database(entities = [CardInfoEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CardInfoDatabase : RoomDatabase(){

    abstract val cardInfoDao: CardInfoDao
}