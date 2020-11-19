package br.com.zup.casadocodigo.state

import br.com.zup.casadocodigo.country.Country
import br.com.zup.casadocodigo.shared.validation.Exists
import br.com.zup.casadocodigo.shared.validation.Unique
import javax.persistence.EntityManager
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class StateRequest(
        @field:NotBlank
        @field:Unique(entityClass = State::class, entityField = "name")
        val name: String,

        @field:NotNull
        @field:Exists(entityClass = Country::class)
        val countryId: Long
) {
    fun toModel(entityManager: EntityManager): State {
        val country = entityManager.find(Country::class.java, countryId)
        return State(name = name, country = country)
    }
}
