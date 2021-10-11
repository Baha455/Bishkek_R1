package com.example.bishkekrielt

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.android.navigationadvancedsample.setupWithNavController
import com.example.bishkekrielt.databinding.FragmentHomeBinding
import com.example.bishkekrielt.ui.RvAdapter
import com.example.bishkekrielt.ui.home.HomeFragment
import com.example.bishkekrielt.ui.home.HomeViewModel
import com.example.bishkekrielt.ui.home.ItemFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)



        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id) {

                R.id.navigation_home -> navView.visibility = View.VISIBLE
                R.id.navigation_dashboard -> navView.visibility = View.VISIBLE
                R.id.navigation_notifications -> navView.visibility = View.VISIBLE
                else -> navView.visibility = View.GONE
            }

            }
        }


}


