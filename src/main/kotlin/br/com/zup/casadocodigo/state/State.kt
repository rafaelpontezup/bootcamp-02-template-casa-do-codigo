package br.com.zup.casadocodigo.state

import br.com.zup.casadocodigo.country.Country
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "states", uniqueConstraints = [
    UniqueConstraint(columnNames = ["name"], name = "uk_state_name")
])
data class State(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @field:NotBlank
        val name: String,

        @field:NotNull
        @Valid
        @ManyToOne
        val country: Country
)
