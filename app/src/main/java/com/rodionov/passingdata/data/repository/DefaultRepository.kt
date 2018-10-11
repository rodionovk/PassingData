package com.rodionov.passingdata.data.repository

import com.rodionov.passingdata.data.repository.Constants.PASSING_DATA
import com.rodionov.passingdata.models.Country
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by Konstantin Rodionov
 * on 11.10.2018.
 */
object DefaultRepository {

    private val subject: BehaviorSubject<Map<String, Any>> = BehaviorSubject.create()
    private val map = HashMap<String, Any>()

    fun passingData(country: Country) {
        map[PASSING_DATA] = country
        subject.onNext(map)
    }

    fun clearData() {
        map.clear()
    }

    fun getSubject(): BehaviorSubject<Map<String, Any>> {
        return subject
    }
}