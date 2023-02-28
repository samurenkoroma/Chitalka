package com.samurenkoroma.library.dto

data class BookReadDto(
    val title: String,
    val content: String?,
    val path: String,
    val id: Long?,
)