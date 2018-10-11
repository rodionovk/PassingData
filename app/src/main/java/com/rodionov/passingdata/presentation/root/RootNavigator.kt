package com.rodionov.passingdata.presentation.root

import android.support.v7.app.AppCompatActivity
import com.rodionov.passingdata.R
import com.rodionov.passingdata.presentation.main.MainFragment

/**
 * Created by Konstantin Rodionov
 * on 11.10.2018.
 */
class RootNavigator(private val activity: AppCompatActivity) {

    private val supportFragmentManager = activity.supportFragmentManager

    private var fragment1: MainFragment
    private var fragment2: MainFragment
    private var fragment3: MainFragment
    private var fragment4: MainFragment
    private var fragment5: MainFragment

    init {
        fragment1 = initContainer("fragment1")
        fragment2 = initContainer("fragment2")
        fragment3 = initContainer("fragment3")
        fragment4 = initContainer("fragment4")
        fragment5 = initContainer("fragment5")

        goToFragment1()
    }

    fun exit() {
        activity.finish()
    }

    fun goToFragment1() {
        supportFragmentManager.beginTransaction()
                .detach(fragment2)
                .detach(fragment3)
                .detach(fragment4)
                .detach(fragment5)
                .attach(fragment1)
                .commitNow()
    }

    fun goToFragment2() {
        supportFragmentManager.beginTransaction()
                .detach(fragment1)
                .detach(fragment3)
                .detach(fragment4)
                .detach(fragment5)
                .attach(fragment2)
                .commitNow()
    }

    fun goToFragment3() {
        supportFragmentManager.beginTransaction()
                .detach(fragment1)
                .detach(fragment2)
                .detach(fragment4)
                .detach(fragment5)
                .attach(fragment3)
                .commitNow()
    }

    fun goToFragment4() {
        supportFragmentManager.beginTransaction()
                .detach(fragment1)
                .detach(fragment2)
                .detach(fragment3)
                .detach(fragment5)
                .attach(fragment4)
                .commitNow()
    }

    fun goToFragment5() {
        supportFragmentManager.beginTransaction()
                .detach(fragment1)
                .detach(fragment2)
                .detach(fragment3)
                .detach(fragment4)
                .attach(fragment5)
                .commitNow()
    }

    private fun initContainer(tag: String): MainFragment {
        var fragment = supportFragmentManager.findFragmentByTag(tag) as? MainFragment
        if (fragment == null) {
            fragment = MainFragment.newInstance(tag)
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, fragment, tag)
                    .detach(fragment)
                    .commitNow()
        }
        return fragment
    }

}