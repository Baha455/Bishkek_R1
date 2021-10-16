package com.example.bishkekrielt

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

    navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {

                R.id.navigation_home -> navView.visibility = View.VISIBLE
                R.id.navigation_notifications -> navView.visibility = View.VISIBLE
                else -> navView.visibility = View.GONE
            }

        }

    }



}


