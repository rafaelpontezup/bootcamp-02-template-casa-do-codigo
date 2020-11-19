package br.com.zup.casadocodigo.country

class CountryResponse(
        val id: Long?,
        val name: String
) {
    constructor(country: Country) : this(country.id, country.name)
}
