package com.robosh.catfact.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.robosh.catfact.R
import com.robosh.catfact.databinding.FragmentDetailsBinding
import com.robosh.catfact.repository.CatMockRepostitory

class DetailsScreen : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ad = CatFactsAdapter()
        with(binding.catFactsRecyclerView) {
            setHasFixedSize(true)
            adapter = ad
            layoutManager = LinearLayoutManager(this@DetailsScreen.requireContext())
        }

        ad.setData(CatMockRepostitory().getCatFacts())
    }
}