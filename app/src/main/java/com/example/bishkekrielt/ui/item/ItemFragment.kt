package com.example.bishkekrielt.ui.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bishkekrielt.R
import com.example.bishkekrielt.data.model.Recatalog
import com.example.bishkekrielt.databinding.FragmentItemBinding
import com.example.bishkekrielt.ui.home.ItemViewModel
import com.squareup.picasso.Picasso
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemFragment: Fragment() {
    private val vm by viewModel<ItemViewModel>()
    var binding: FragmentItemBinding? = null
    val args: ItemFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        MapKitFactory.initialize(context)
        binding = FragmentItemBinding.inflate(layoutInflater)
        return  binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
        setupView()
        setUpMapView()
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

    private fun setupListener(){
        binding?.btnBack?.setOnClickListener{
            findNavController().popBackStack()
        }

        binding?.mapView?.setOnClickListener{
            toMapFragment(args.reCatalog)
        }
    }

    private fun setUpMapView(){
        val item = args.reCatalog
        binding?.mapView?.setNoninteractive(true)
        binding?.mapView?.map?.move(
            CameraPosition(Point(item.latitude, item.longitude), 18.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 0F), null
        )

    }

    private fun toMapFragment(data: Recatalog){
        val destination = ItemFragmentDirections.actionItemFragment2ToMapFragment(data)
        findNavController().navigate(destination)
    }

    override fun onStart() {
        super.onStart()
        binding?.mapView?.onStart()
        MapKitFactory.getInstance().onStart()
    }

    override fun onStop() {
        super.onStop()
        binding?.mapView?.onStop()
        MapKitFactory.getInstance().onStop()
    }
}