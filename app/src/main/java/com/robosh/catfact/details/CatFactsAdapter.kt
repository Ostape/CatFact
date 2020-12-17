package com.robosh.catfact.details

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.robosh.catfact.model.CatFact

class CatFactsAdapter(
    private val clickListener: CatFactClickListenerFactory
) : RecyclerView.Adapter<CatFactViewHolder>() {

    private val catFacts = ArrayList<CatFact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatFactViewHolder {
        return CatFactViewHolder.create(parent, clickListener)
    }

    override fun getItemCount() = catFacts.size

    override fun onBindViewHolder(holder: CatFactViewHolder, position: Int) {
        holder.bind(catFacts[position])
    }

    fun setData(list: List<CatFact>) {
        catFacts.clear()
        catFacts.addAll(list)
        notifyDataSetChanged()
    }
}