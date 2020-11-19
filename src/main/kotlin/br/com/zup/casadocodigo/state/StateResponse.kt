package br.com.zup.casadocodigo.state

import br.com.zup.casadocodigo.country.Country

class StateResponse(
        val id: Long?,
        val name: String,
        val country: Country
) {
    constructor(state: State) : this(state.id, state.name, state.country)
}
