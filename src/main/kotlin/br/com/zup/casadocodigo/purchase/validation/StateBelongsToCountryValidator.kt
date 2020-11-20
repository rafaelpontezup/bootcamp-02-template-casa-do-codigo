package br.com.zup.casadocodigo.purchase.validation

import br.com.zup.casadocodigo.country.Country
import br.com.zup.casadocodigo.purchase.PurchaseRequest
import br.com.zup.casadocodigo.state.State
import javax.persistence.EntityManager
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class StateBelongsToCountryValidator(
        val entityManager: EntityManager
) : ConstraintValidator<StateBelongsToCountry, PurchaseRequest> {

    override fun initialize(constraint: StateBelongsToCountry) {
        // nothing to initialize
    }

    override fun isValid(value: PurchaseRequest, context: ConstraintValidatorContext): Boolean {
        if (value.stateId == null) {
            return true
        }

        val country = entityManager.find(Country::class.java, value.countryId)
        val state = entityManager.find(State::class.java, value.stateId)

        return state?.country == country
    }

}
