package com.rodionov.passingdata.presentation.country

import android.support.v4.app.Fragment

/**
 * Created by Konstantin Rodionov
 * on 11.10.2018.
 */
class CountryNavigator(fragment: Fragment) {

    private val fragmentManager = fragment.activity?.supportFragmentManager

    fun close() {
        fragmentManager ?: return
        fragmentManager.popBackStack()
    }
}