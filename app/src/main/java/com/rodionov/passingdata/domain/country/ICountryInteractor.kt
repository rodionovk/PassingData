package com.rodionov.passingdata.domain.country

import com.rodionov.passingdata.models.Country
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by Konstantin Rodionov
 * on 11.10.2018.
 */
interface ICountryInteractor {
    fun chooseCountry(country: Country)
    fun getSubject(): BehaviorSubject<Map<String, Any>>
    fun clear()
}