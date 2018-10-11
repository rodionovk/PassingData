package com.rodionov.passingdata.domain.country

import com.rodionov.passingdata.data.repository.DefaultRepository
import com.rodionov.passingdata.models.Country
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by Konstantin Rodionov
 * on 11.10.2018.
 */
class CountryInteractor(
        private val repository: DefaultRepository
): ICountryInteractor {

    override fun chooseCountry(country: Country) {
        repository.passingData(country)
    }

    override fun getSubject(): BehaviorSubject<Map<String, Any>> {
        return repository.getSubject()
    }

    override fun clear() {
        repository.clearData()
    }

}