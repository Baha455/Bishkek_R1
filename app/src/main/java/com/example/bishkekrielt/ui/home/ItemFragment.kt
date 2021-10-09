package com.example.bishkekrielt.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bishkekrielt.R
import com.example.bishkekrielt.data.common.BaseFragment
import com.example.bishkekrielt.data.common.SharedViewModel
import com.example.bishkekrielt.databinding.FragmentHomeBinding
import com.example.bishkekrielt.databinding.FragmentItemBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemFragment: Fragment() {
    private val vm by viewModel<ItemViewModel>()
    private lateinit var viewModel: SharedViewModel
    var binding: FragmentItemBinding? = null
    val args: ItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemBinding.inflate(layoutInflater)
        return  binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back()
        setupView()
    }

    private fun setupView(){
        val item = args.reCatalog
        binding?.tv1?.text =item.floor
    }

    private fun back(){

        binding?.btnBack?.setOnClickListener{
            findNavController().popBackStack()
            /*val destination = ItemFragmentDirections.actionItemFragment2ToNavigationHome()
            findNavController().navigate(destination)*/
        }
    }
}