package com.example.onlinestore.data.di

import com.example.bishkekrielt.data.remote.RetrofitBuilder
import com.example.bishkekrielt.data.repository.Repository
import com.example.bishkekrielt.data.repository.RepositoryImp
import com.example.bishkekrielt.data.remote.RetrofitService
import com.example.bishkekrielt.ui.home.HomeViewModel
import com.example.bishkekrielt.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { HomeViewModel(get()) }
    viewModel { SplashViewModel() }
}

val repositoryModule: Module = module {
    single<Repository>{RepositoryImp(get())}
}

val apiModule: Module = module {
        single<RetrofitService> { RetrofitBuilder.buildRetrofit() }

}

val appModules =
    listOf(viewModelModule, apiModule, repositoryModule)