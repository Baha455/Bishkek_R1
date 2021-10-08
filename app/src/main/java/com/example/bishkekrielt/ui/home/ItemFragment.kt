package com.example.bishkekrielt.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bishkekrielt.R
import com.example.bishkekrielt.databinding.FragmentItemBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.ext.android.bind

class ItemFragment: Fragment() {

    var binding: FragmentItemBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back()
    }

    private fun back(){
        binding?.btnBack?.setOnClickListener{
            val destination = ItemFragmentDirections.actionItemFragment2ToNavigationHome()
            findNavController().navigate(destination)
            /*val nav = activity?.findViewById<BottomNavigationView>(R.id.nav_view)
            nav?.visibility = View.VISIBLE*/
        }
    }
}