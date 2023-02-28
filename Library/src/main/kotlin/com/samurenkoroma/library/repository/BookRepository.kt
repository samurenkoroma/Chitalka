package com.samurenkoroma.library.repository

import com.samurenkoroma.library.database.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long> {
}