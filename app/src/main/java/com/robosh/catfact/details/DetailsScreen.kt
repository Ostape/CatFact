package com.robosh.catfact.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.robosh.catfact.databinding.FragmentDetailsBinding
import com.robosh.catfact.model.CatFact
import com.robosh.catfact.repository.CatMockRepostitory

class DetailsScreen : Fragment(), CatFactClickListenerFactory {

    private lateinit var catFactsAdapter: CatFactsAdapter
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        catFactsAdapter = CatFactsAdapter(this)
    }

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
        with(binding.catFactsRecyclerView) {
            setHasFixedSize(true)
            adapter = catFactsAdapter
            layoutManager = LinearLayoutManager(this@DetailsScreen.requireContext())
        }

        catFactsAdapter.setData(CatMockRepostitory().getCatFacts())
    }

    override fun createOnClickListener(catFact: CatFact) {
        Log.d("TAGGER", catFact.toString())
    }
}