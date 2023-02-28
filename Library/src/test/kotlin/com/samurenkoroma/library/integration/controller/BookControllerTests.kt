package com.samurenkoroma.library.integration.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.samurenkoroma.library.database.entity.Book
import com.samurenkoroma.library.dto.BookReadDto
import com.samurenkoroma.library.integration.AbstractTestcontainersIntegrationTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
class BookControllerTests(private var mockMvc: MockMvc, private val objectMapper: ObjectMapper) :
    AbstractTestcontainersIntegrationTest() {

    @Test
    fun findAllPageable() {
        val response = mockMvc.perform(get("/books?size=2")).andExpectAll(
            status().is2xxSuccessful
        ).andReturn()
        val size = objectMapper.readValue(response.response.contentAsString, List::class.java).size
        assertEquals(2, size)
    }

    @Test
    fun findAll() {
        mockMvc.perform(get("/books")).andExpectAll(
            status().is2xxSuccessful
        )
    }

    @Test
    fun findById() {
        val responseBook = mockMvc.perform(get("/books/2")).andExpectAll(
            status().is2xxSuccessful,
        ).andReturn().response
        val book = objectMapper.readValue(responseBook.contentAsString, BookReadDto::class.java)
        assertEquals(2, book.id)
    }

    @Test
    fun create() {
        val bookDto = Book("Cool Gadget", "Looks cool", "Looks cool")
        val response = mockMvc.perform(
            post("/books")
                .content(objectMapper.writeValueAsString(bookDto))
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
        ).andExpectAll(
            status().is2xxSuccessful,
        ).andReturn().response


        val created = objectMapper.readValue(response.contentAsString, BookReadDto::class.java)
        assertEquals(bookDto.content, created.content)
        assertEquals(bookDto.title, created.title)
        assertEquals(bookDto.path, created.path)
    }

    @Test
    fun update() {
        mockMvc.perform(
            put("/books/1")
                .content(objectMapper.writeValueAsString(Book("Cool Gadget", "Looks cool", "Looks cool")))
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
        ).andExpectAll(
            status().is2xxSuccessful,
        )
    }

    @Test
    fun delete() {
        mockMvc.perform(delete("/books/1")).andExpectAll(
            status().is2xxSuccessful,
            content().string("delete/1"),
        )
    }
}
