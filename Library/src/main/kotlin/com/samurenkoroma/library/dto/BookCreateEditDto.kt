package com.samurenkoroma.library.dto

data class BookCreateEditDto(
    val title: String,
    val content: String?,
    val path: String,
)