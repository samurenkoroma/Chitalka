package com.samurenkoroma.library.controller

import com.samurenkoroma.library.dto.BookCreateEditDto
import com.samurenkoroma.library.dto.BookReadDto
import com.samurenkoroma.library.service.BookService
import org.springframework.data.domain.Pageable
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/books")
class BookController(private val bookService: BookService) {
    @GetMapping()
    fun findAll(pageable: Pageable): MutableList<BookReadDto>? {
        return bookService.findAll(pageable)
    }

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long): Optional<BookReadDto> {
        return bookService.findById(id)
    }

    @PostMapping
    fun create(@Validated @RequestBody bookDto: BookCreateEditDto): BookReadDto {
        return bookService.create(bookDto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Validated @RequestBody bookDto: BookCreateEditDto): Optional<BookReadDto> {
        return bookService.update(id, bookDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): String {
        return "delete/${id}"
    }
}