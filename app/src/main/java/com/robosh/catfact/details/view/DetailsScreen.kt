package com.robosh.catfact.details.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.robosh.catfact.application.toObservableList
import com.robosh.catfact.databinding.FragmentDetailsBinding
import com.robosh.catfact.details.viewmodel.DetailsViewModel
import com.robosh.catfact.model.CatFact
import com.robosh.catfact.net.RetrofitClientInstance
import com.robosh.catfact.net.RetrofitInstance2
import com.robosh.catfact.net.api.CatFactApi
import com.robosh.catfact.net.api.CatImageApi
import com.robosh.catfact.net.repository.CatMockRepostitory
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsScreen : Fragment(),
    CatFactClickListenerFactory {

    private lateinit var catFactsAdapter: CatFactsAdapter
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: DetailsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        catFactsAdapter = CatFactsAdapter(this)

//        RetrofitClientInstance.retrofitInstance!!.create(CatImageApi::class.java).getImageFile()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe {
//                Log.d("TAGGERR", it.toString())
//            }

        RetrofitInstance2.retrofitInstance!!.create(CatFactApi::class.java).getCatFacts()
            .flatMap {
                it.map { catFact ->
                    RetrofitClientInstance.retrofitInstance!!.create(CatImageApi::class.java)
                        .getImageFile().map {
                            Observable.just(CatFact(it.file, catFact.text!!))
                        }
                        .onErrorReturn {
                            Observable.just(CatFact("", catFact.text!!))
                        }
                        .blockingFirst()

                }.toObservableList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("TAGGERR", it.toString())
            }, {
                Log.d("TAGGERR", it.toString())
            }
            )
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
        viewModel.getCatFacts()

        catFactsAdapter.setData(CatMockRepostitory().getCatFacts())
    }

    override fun createOnClickListener(catFact: CatFact) {
        Log.d("TAGGER", catFact.toString())
    }
}