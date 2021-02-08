package com.bankwithmit.data.mapper

interface BaseMapper<E, D> {
    fun transform(type: E): D
}