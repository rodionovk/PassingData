package com.rodionov.passingdata.presentation.root

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.rodionov.passingdata.R
import kotlinx.android.synthetic.main.activity_main.*

class RootActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var presenter: RootPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navigator = RootNavigator(this)
        presenter = RootPresenter(navigator)
        initView()
    }

    private fun initView() {
        setContentView(R.layout.activity_main)

        tab1.setOnClickListener(this)
        tab2.setOnClickListener(this)
        tab3.setOnClickListener(this)
        tab4.setOnClickListener(this)
        tab5.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        presenter.click(v.id)
    }
}
