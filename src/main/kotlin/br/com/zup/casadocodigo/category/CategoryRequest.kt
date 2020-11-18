package br.com.zup.casadocodigo.category

import br.com.zup.casadocodigo.shared.validation.Unique
import javax.validation.constraints.NotBlank

class CategoryRequest(
        @field:NotBlank
        @field:Unique(entityClass = Category::class, entityField = "name")
        val name: String
) {
    fun toModel() = Category(name = name)
}
