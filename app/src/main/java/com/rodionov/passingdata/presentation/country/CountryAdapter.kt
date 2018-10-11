package com.rodionov.passingdata.presentation.country

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rodionov.passingdata.R
import com.rodionov.passingdata.models.Country

/**
 * Created by Konstantin Rodionov
 * on 11.10.2018.
 */
class CountryAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = listOf(
            Country("Россия"),
            Country("Зимбабве"),
            Country("Канада"),
            Country("Австралия"),
            Country("Греция")
    )

    var onItemClick: ((Country) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CountryHolder).onBind(data[position])
    }

    inner class CountryHolder(view: View): RecyclerView.ViewHolder(view) {
        private val title = itemView.findViewById<TextView>(R.id.text)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(it.tag as Country)
            }
        }

        fun onBind(country: Country) {
            title.text = country.name
            itemView.tag = country
        }
    }
}