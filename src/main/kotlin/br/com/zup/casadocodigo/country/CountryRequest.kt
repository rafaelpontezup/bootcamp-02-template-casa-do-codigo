package br.com.zup.casadocodigo.country

import br.com.zup.casadocodigo.shared.validation.Unique
import javax.validation.constraints.NotBlank

class CountryRequest(
        @field:NotBlank
        @field:Unique(entityClass = Country::class, entityField = "name")
        val name: String
) {
    fun toModel() = Country(name = name)
}
