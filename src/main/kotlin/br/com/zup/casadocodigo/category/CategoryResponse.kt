package br.com.zup.casadocodigo.category

class CategoryResponse(
        val id: Long?,
        val name: String
) {
    constructor(model: Category) : this(model.id, model.name)
}
