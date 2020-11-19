package br.com.zup.casadocodigo.book

import br.com.zup.casadocodigo.book.Book.Companion.FIND_ALL
import br.com.zup.casadocodigo.shared.validation.Exists
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityManager
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
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

    @GetMapping("/books")
    fun retrieveAll(): ResponseEntity<List<BookListResponse>> {
        val books = entityManager
                .createNamedQuery(FIND_ALL, Book::class.java)
                .resultList
        return ResponseEntity.ok(BookListResponse.of(books))
    }

    @GetMapping("/books/{id}")
    fun retrieve(
            @Exists(entityClass = Book::class) @PathVariable id: Long
    ): ResponseEntity<BookDetailResponse> {
        val book = entityManager.find(Book::class.java, id)
        return ResponseEntity.ok(BookDetailResponse(book))
    }

}
