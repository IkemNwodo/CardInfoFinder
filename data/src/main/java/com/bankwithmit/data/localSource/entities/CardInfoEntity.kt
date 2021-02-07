package com.bankwithmit.data.localSource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bankwithmit.data.utils.Constants.CARD_INFO_TABLE_NAME

@Entity(tableName = CARD_INFO_TABLE_NAME)
data class CardInfoEntity(

    @PrimaryKey
    @ColumnInfo(name = "unique_id")
    val id: Int? = 0,
    val bank: Bank?,
    val brand: String? = "",
    val country: Country?,
    val type: String? = ""
)
