package br.com.zup.casadocodigo.purchase

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.persistence.EntityManager
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
class PurchaseController(val entityManager: EntityManager) {

    @Transactional
    @PostMapping("/purchases")
    fun create(
            @Valid @RequestBody request: PurchaseRequest,
            uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<Unit> {
        val purchase = request.toModel(entityManager)
        entityManager.persist(purchase)

        val uri = uriComponentsBuilder
                .path("/purchases/${purchase.id}")
                .build().toUri()
        return ResponseEntity.created(uri).build()
    }

}
