package com.example.bishkekrielt

import android.app.Application
import com.example.onlinestore.data.di.appModules
import org.koin.android.ext.koin.androidContext

import org.koin.core.context.startKoin

class BishkekRieltApp: Application() {

    override fun onCreate() {
        super.onCreate()
         startKoin{
             androidContext(this@BishkekRieltApp)
             modules(appModules)
         }
    }
}