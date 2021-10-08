package com.example.bishkekrielt.data.local

import android.content.Context
import android.content.SharedPreferences


object PreferenceHelper {

    private const val PREFERENCE_NAME ="RieltPreference"
    private var preference: SharedPreferences? = null

    fun init(context: Context){
        preference = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
        )

    }
}