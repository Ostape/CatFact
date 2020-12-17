package com.robosh.catfact.details.di

import com.robosh.catfact.details.viewmodel.DetailsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailsModule = module {

    viewModel { DetailsViewModel() }
}