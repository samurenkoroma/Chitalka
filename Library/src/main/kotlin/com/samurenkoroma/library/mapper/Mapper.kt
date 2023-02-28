package com.samurenkoroma.library.mapper

interface Mapper<F, T> {
    fun map(o: F): T

    fun map(fromObject: F, toObject: T): T {
        return toObject
    }
}