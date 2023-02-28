package com.samurenkoroma.library.database.entity

import jakarta.persistence.*

@Entity
@Table(name = "books")
class Book(
    var title: String,
    var content: String?,
    var path: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)
