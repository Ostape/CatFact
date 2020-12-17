package com.robosh.catfact.details.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.robosh.catfact.databinding.FragmentDetailsBinding
import com.robosh.catfact.details.viewmodel.DetailsViewModel
import com.robosh.catfact.model.CatFact
import com.robosh.catfact.model.ResultState
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsScreen : Fragment(),
    CatFactClickListenerFactory {

    private lateinit var catFactsAdapter: CatFactsAdapter
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: DetailsViewModel by viewModel()

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
        viewModel.state.observe(viewLifecycleOwner, Observer {
            if (it is ResultState.DataListState) {
                catFactsAdapter.setData(it.data)
                Log.d("TAGGERR", it.data.toString())
            }
            if (it is ResultState.ErrorState) {
                Log.d("TAGGERR", it.data)
            }
            if (it is ResultState.LoadingState) {
                Log.d("TAGGERR", "Loafing")
            }
        })
        viewModel.processAction()
    }

    override fun createOnClickListener(catFact: CatFact) {
        Log.d("TAGGER", catFact.toString())
    }
}