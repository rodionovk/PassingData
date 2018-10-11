package com.rodionov.passingdata.presentation.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.rodionov.passingdata.R
import com.rodionov.passingdata.data.repository.DefaultRepository
import com.rodionov.passingdata.domain.country.CountryInteractor
import com.rodionov.passingdata.models.Country

/**
 * Created by Konstantin Rodionov
 * on 10.10.2018.
 */
class MainFragment: Fragment(), IMainView {

    private lateinit var title: TextView
    private lateinit var countryName: TextView
    private lateinit var choose: Button

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val interactor = CountryInteractor(DefaultRepository)
        val navigator = MainNavigator(this)
        presenter = MainPresenter(this, interactor, navigator)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title = view.findViewById(R.id.title)
        countryName = view.findViewById(R.id.country)
        choose = view.findViewById(R.id.btn_choose)

        title.text = getContainerName()

        choose.setOnClickListener {
            presenter.chooseCountry()
        }
    }

    private fun getContainerName() : String {
        return  arguments?.getString(EXTRA_TITLE) ?: ""
    }


    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        presenter.onViewStateRestored()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDestroyView()
    }

    override fun setCountry(country: Country) {
        countryName.text = country.name
    }

    companion object {
        private const val EXTRA_TITLE = "title"

        fun newInstance(title: String): MainFragment {
            val fragment = MainFragment()
            val args = Bundle()
            args.putString(EXTRA_TITLE, title)
            fragment.arguments = args
            return fragment

        }
    }
}