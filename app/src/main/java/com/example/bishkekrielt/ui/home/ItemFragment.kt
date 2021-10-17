package com.example.bishkekrielt.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bishkekrielt.R
import com.example.bishkekrielt.databinding.FragmentHomeBinding
import com.example.bishkekrielt.databinding.FragmentItemBinding
import com.squareup.picasso.Picasso
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemFragment: Fragment() {
    private val vm by viewModel<ItemViewModel>()
    var binding: FragmentItemBinding? = null
    val args: ItemFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //MapKitFactory.setApiKey("3b93339d-bcba-43ed-a270-a92079534723")
        MapKitFactory.initialize(context)
        binding = FragmentItemBinding.inflate(layoutInflater)
        return  binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back()
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

    private fun back(){
        binding?.btnBack?.setOnClickListener{
            findNavController().popBackStack()
        }
    }

    private fun setUpMapView(){
        binding?.mapView?.map?.move(
            CameraPosition(Point(42.863759, 74.547556), 18.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 0F), null
        )
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