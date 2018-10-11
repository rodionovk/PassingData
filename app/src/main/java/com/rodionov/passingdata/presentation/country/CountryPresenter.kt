package com.rodionov.passingdata.presentation.country

import com.rodionov.passingdata.domain.country.ICountryInteractor
import com.rodionov.passingdata.models.Country

/**
 * Created by Konstantin Rodionov
 * on 11.10.2018.
 */
class CountryPresenter(
        private val interactor: ICountryInteractor,
        private val navigator: CountryNavigator
) {

    fun countryChoosed(country: Country) {
        interactor.chooseCountry(country)
        navigator.close()
    }
}