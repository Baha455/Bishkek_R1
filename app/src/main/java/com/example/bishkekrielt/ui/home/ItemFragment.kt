package com.example.bishkekrielt.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bishkekrielt.R
import com.example.bishkekrielt.databinding.FragmentItemBinding
import com.squareup.picasso.Picasso
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemFragment: Fragment() {
    private val vm by viewModel<ItemViewModel>()
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
        binding?.area?.text = context?.getString(R.string.areaFormat, item.area)
        binding?.kitchen?.text = context?.getString(R.string.areaFormat, item.kitchen)
        binding?.price1?.text = context?.getString(R.string.priceFormat, item.price)
        binding?.rooms?.text = context?.getString(R.string.roomsFormat, item.rooms.toString())
        binding?.floor?.text = item.floor
        binding?.tvLocation?.text = item.location
        Picasso.get()
            .load(item.image)
            .into(binding?.scrollImage)

    }

    private fun back(){

        binding?.btnBack?.setOnClickListener{
            findNavController().popBackStack()
        }
    }
}