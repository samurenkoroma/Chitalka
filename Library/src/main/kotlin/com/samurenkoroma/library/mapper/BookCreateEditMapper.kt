package com.samurenkoroma.library.mapper

import com.samurenkoroma.library.database.entity.Book
import com.samurenkoroma.library.dto.BookCreateEditDto
import org.springframework.stereotype.Component

@Component
class BookCreateEditMapper : Mapper<BookCreateEditDto, Book> {
    override fun map(o: BookCreateEditDto): Book {
        return Book(o.title, o.content, o.path)
    }

    override fun map(fromObject: BookCreateEditDto, toObject: Book): Book {
        toObject.content = fromObject.content
        toObject.title = fromObject.title
        toObject.path = fromObject.path
        return toObject
    }
}