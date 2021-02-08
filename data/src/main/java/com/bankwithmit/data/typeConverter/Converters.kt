package com.bankwithmit.data.typeConverter

import androidx.room.TypeConverter
import com.bankwithmit.data.remoteSource.response.Bank
import com.bankwithmit.data.remoteSource.response.Country
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {
    val gson = Gson()

    val typeBank: Type = object : TypeToken<Bank?>() {}.type
    val typeCountry: Type = object : TypeToken<Country?>() {}.type

    @TypeConverter
    fun fromBank(bank: Bank?): String{
        return gson.toJson(bank,typeBank)
    }

    @TypeConverter
    fun toBank(json: String?): Bank {
        return gson.fromJson(json,typeBank)
    }

    @TypeConverter
    fun fromCountry(country: Country?): String{
        return gson.toJson(country,typeCountry)
    }

    @TypeConverter
    fun toCountry(json: String?): Country {
        return gson.fromJson(json,typeCountry)
    }
}