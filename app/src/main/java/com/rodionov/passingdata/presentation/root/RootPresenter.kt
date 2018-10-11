package com.rodionov.passingdata.presentation.root

import com.rodionov.passingdata.R

/**
 * Created by Konstantin Rodionov
 * on 11.10.2018.
 */
class RootPresenter(
        private val navigator: RootNavigator
) {

    fun click(viewId: Int) {
        when (viewId) {
            R.id.tab1 -> navigator.goToFragment1()
            R.id.tab2 -> navigator.goToFragment2()
            R.id.tab3 -> navigator.goToFragment3()
            R.id.tab4 -> navigator.goToFragment4()
            R.id.tab5 -> navigator.goToFragment5()
        }
    }
}