package br.com.zup.casadocodigo.coupon

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Future
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Entity
@Table(name = "coupons", uniqueConstraints = [
    UniqueConstraint(columnNames = ["code"], name = "uk_coupon_code")
])
data class Coupon(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @field:NotBlank
        val code: String,

        @field:Positive
        @field:NotNull
        val discount: BigDecimal,

        @field:Future
        @field:NotNull
        val validUntil: LocalDate
) {
    fun isValid() = LocalDate.now() <= validUntil;
}
