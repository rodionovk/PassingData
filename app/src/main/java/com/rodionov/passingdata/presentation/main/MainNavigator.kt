package com.rodionov.passingdata.presentation.main

import android.support.v4.app.Fragment
import com.rodionov.passingdata.R
import com.rodionov.passingdata.presentation.country.CountryFragment

/**
 * Created by Konstantin Rodionov
 * on 10.10.2018.
 */
class MainNavigator(fragment: Fragment) {

    private val fragmentManager = fragment.activity?.supportFragmentManager

    fun chooseCountry() {
        fragmentManager ?: return

        val fragment = CountryFragment()
        val tag =  CountryFragment::class.java.name

        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment, tag)
                .addToBackStack(tag)
                .commit()

    }
}