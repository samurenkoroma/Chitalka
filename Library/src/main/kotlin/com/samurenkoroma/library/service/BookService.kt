package com.samurenkoroma.library.service

import com.samurenkoroma.library.dto.BookCreateEditDto
import com.samurenkoroma.library.dto.BookReadDto
import com.samurenkoroma.library.mapper.BookCreateEditMapper
import com.samurenkoroma.library.mapper.BookReadMapper
import com.samurenkoroma.library.repository.BookRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class BookService(
    private val bookRepository: BookRepository,
    private val bookReadMapper: BookReadMapper,
    private val bookCreateEditMapper: BookCreateEditMapper,
) {
    fun findAll(pageable: Pageable): MutableList<BookReadDto>? {
        return bookRepository.findAll(pageable).stream().map(bookReadMapper::map).toList()
    }

    fun findById(id: Long): Optional<BookReadDto> {
        return bookRepository.findById(id).map(bookReadMapper::map)
    }

    @Transactional
    fun create(dto: BookCreateEditDto): BookReadDto {
        return Optional.of(dto)
            .map(bookCreateEditMapper::map)
            .map(bookRepository::save)
            .map(bookReadMapper::map)
            .orElseThrow()
    }

    @Transactional
    fun update(id: Long, dto: BookCreateEditDto): Optional<BookReadDto> {
        return bookRepository.findById(id)
            .map { entity -> bookCreateEditMapper.map(dto, entity) }
            .map(bookRepository::saveAndFlush)
            .map(bookReadMapper::map)
    }
}