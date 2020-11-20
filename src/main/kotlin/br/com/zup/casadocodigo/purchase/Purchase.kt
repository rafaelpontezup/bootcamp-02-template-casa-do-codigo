package br.com.zup.casadocodigo.purchase

import br.com.zup.casadocodigo.country.Country
import br.com.zup.casadocodigo.shared.validation.CEP
import br.com.zup.casadocodigo.shared.validation.Document
import br.com.zup.casadocodigo.state.State
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "purchases")
class Purchase(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @field:Email
        @field:NotBlank
        val email: String,

        @field:NotBlank
        val name: String,

        @field:NotBlank
        val surname: String,

        @field:Document
        @field:NotBlank
        val document: String,

        @field:NotBlank
        val address: String,

        @field:NotBlank
        val complement: String,

        @field:NotBlank
        val city: String,

        @field:NotNull
        @Valid
        @ManyToOne
        val country: Country,

        @Valid
        @ManyToOne
        val state: State?,

        @field:NotBlank
        val phone: String,

        @field:CEP
        @field:NotBlank
        val cep: String,

        @field:Size(min = 1)
        @Valid
        @ElementCollection
        val items: Set<LineItem> = hashSetOf(),

        @Enumerated(EnumType.STRING)
        val status: Status = Status.DEFERRED
)
