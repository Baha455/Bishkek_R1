package com.example.onlinestore.data.di

import com.example.bishkekrielt.data.interactors.RieltInteractor
import com.example.bishkekrielt.data.interactors.RieltInteractorImp
import com.example.bishkekrielt.data.remote.RetrofitBuilder
import com.example.bishkekrielt.data.remote.SharesService
import com.example.bishkekrielt.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { HomeViewModel(get()) }
}

val repositoryModule: Module = module {
}

val apiModule: Module = module {
        single<SharesService> { RetrofitBuilder.buildRetrofit() }
        single< RieltInteractor> {RieltInteractorImp(get()) }

}

val appModules =
    listOf(viewModelModule, apiModule)