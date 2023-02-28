package com.samurenkoroma.library.mapper

import com.samurenkoroma.library.database.entity.Book
import com.samurenkoroma.library.dto.BookReadDto
import org.springframework.stereotype.Component

@Component
class BookReadMapper : Mapper<Book, BookReadDto> {
    override fun map(o: Book): BookReadDto {
        return BookReadDto(o.title, o.content, o.path, o.id)
    }
}