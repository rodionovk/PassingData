package com.rodionov.passingdata.presentation.main

import com.rodionov.passingdata.data.repository.Constants.PASSING_DATA
import com.rodionov.passingdata.domain.country.ICountryInteractor
import com.rodionov.passingdata.models.Country
import io.reactivex.disposables.Disposable

/**
 * Created by Konstantin Rodionov
 * on 10.10.2018.
 */
class MainPresenter(
        private val view: IMainView,
        private val interactor: ICountryInteractor,
        private val navigator: MainNavigator
) {

    private var disposable: Disposable? = null

    fun onViewStateRestored() {
        disposable = interactor.getSubject()
                .subscribe {
                    val data = it[PASSING_DATA]
                    if (data != null && data is Country) {
                        view.setCountry(data)
                    }
                }
    }

    fun onDestroyView() {
        disposable?.dispose()
        interactor.clear()
    }

    fun chooseCountry() {
        navigator.chooseCountry()
    }
}