package com.samurenkoroma.library.integration.service

import com.samurenkoroma.library.dto.BookCreateEditDto
import com.samurenkoroma.library.dto.BookReadDto
import com.samurenkoroma.library.integration.AbstractTestcontainersIntegrationTest
import com.samurenkoroma.library.service.BookService
import lombok.RequiredArgsConstructor
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@RequiredArgsConstructor
class BookServiceTests(var bookService: BookService) : AbstractTestcontainersIntegrationTest() {

    @Test
    fun findById() {
        val result = bookService.findById(1L)
        assertTrue(result.isPresent)
        result.ifPresent { assertInstanceOf(BookReadDto::class.java, it) }
    }

    @Test
    fun create() {
        val dto = BookCreateEditDto("Книга1", "о чем-то", "/где/то")
        val actualBook = bookService.create(dto)
        assertEquals(dto.content, actualBook.content)
        assertEquals(dto.path, actualBook.path)
        assertEquals(dto.title, actualBook.title)
    }

    @Test
    fun update() {
        val dto = BookCreateEditDto("Книга1", "о чем-то", "/где/то")
        val actualBook = bookService.update(1L, dto)
        assertTrue(actualBook.isPresent)
        actualBook.ifPresent {
            assertEquals(dto.content, it.content)
            assertEquals(dto.path, it.path)
            assertEquals(dto.title, it.title)
        }
    }

}

