package br.com.zup.casadocodigo.book

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityManager
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
class BookController(val entityManager: EntityManager) {

    @Transactional
    @PostMapping("/books")
    fun create(
            @Valid @RequestBody request: BookRequest
    ): ResponseEntity<BookResponse> {
        val book = request.toModel(entityManager)
        entityManager.persist(book)
        return ResponseEntity.ok(BookResponse(book))
    }

}
