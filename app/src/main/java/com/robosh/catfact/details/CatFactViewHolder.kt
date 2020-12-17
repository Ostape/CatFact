package com.robosh.catfact.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.robosh.catfact.R
import com.robosh.catfact.databinding.ViewHolderCatFactBinding
import com.robosh.catfact.model.CatFact

class CatFactViewHolder private constructor(
    view: View,
    private val clickListener: CatFactClickListenerFactory
) : RecyclerView.ViewHolder(view) {

    companion object {
        fun create(
            parent: ViewGroup, clickListener: CatFactClickListenerFactory
        ): CatFactViewHolder {
            return CatFactViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_cat_fact, parent, false), clickListener
            )
        }
    }

    private val binding: ViewHolderCatFactBinding = ViewHolderCatFactBinding.bind(view)

    fun bind(catFact: CatFact) {
        with(binding) {
//            catFactImage.setImageURI()
            catFactDescription.text = catFact.description
            catFactViewHolderItem.setOnClickListener { clickListener.createOnClickListener(catFact) }
        }
    }
}