package com.example.bishkekrielt.ui.item


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bishkekrielt.databinding.FragmentMapBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition

class MapFragment: Fragment(){
    var binding: FragmentMapBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        MapKitFactory.initialize(context)
        binding = FragmentMapBinding.inflate(layoutInflater)
        return  binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpMapView()
        back()
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

    private fun back(){
        binding?.btnBack?.setOnClickListener{
            findNavController().popBackStack()
        }
    }
}