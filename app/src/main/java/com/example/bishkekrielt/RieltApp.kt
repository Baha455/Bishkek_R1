package com.example.bishkekrielt

import android.app.Application
import com.example.bishkekrielt.data.local.PreferenceHelper
import com.example.onlinestore.data.di.appModules
import org.koin.android.ext.koin.androidContext

import org.koin.core.context.startKoin

class RieltApp: Application() {

    override fun onCreate() {
        super.onCreate()
        /*PreferenceHelper.init(applicationContext)*/
         startKoin{
             androidContext(this@RieltApp)
             modules(appModules)
         }
    }
}