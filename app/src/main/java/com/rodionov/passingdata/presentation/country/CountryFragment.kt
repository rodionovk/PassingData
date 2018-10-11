package com.rodionov.passingdata.presentation.country

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rodionov.passingdata.R
import com.rodionov.passingdata.data.repository.DefaultRepository
import com.rodionov.passingdata.domain.country.CountryInteractor

/**
 * Created by Konstantin Rodionov
 * on 10.10.2018.
 */
class CountryFragment: Fragment() {

    private lateinit var presenter: CountryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val interactor = CountryInteractor(DefaultRepository)
        val navigator = CountryNavigator(this)
        presenter = CountryPresenter(interactor, navigator)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = CountryAdapter()

        adapter.onItemClick = {
            presenter.countryChoosed(country = it)
        }

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }
}