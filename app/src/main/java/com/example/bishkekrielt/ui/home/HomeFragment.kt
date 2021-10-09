package com.example.bishkekrielt.ui.home
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bishkekrielt.R
import com.example.bishkekrielt.data.common.BaseFragment
import com.example.bishkekrielt.data.common.SharedViewModel
import com.example.bishkekrielt.data.model.Data
import com.example.bishkekrielt.data.model.Recatalog
import com.example.bishkekrielt.databinding.FragmentHomeBinding
import com.example.bishkekrielt.ui.RvAdapter
import com.example.bishkekrielt.ui.dashboard.DashboardViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(){

    private lateinit var viewModel: SharedViewModel

    var binding: FragmentHomeBinding? = null
    private val vm by viewModel<HomeViewModel>()
    private val adapter by lazy { RvAdapter(vm) {
        toItemActivity(it)} }

    //override fun resID() = R.layout.fragment_home

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return  binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel::class.java)
        viewModel.bundleFromFragmentBToFragmentA.observe(viewLifecycleOwner, Observer {
            initVM()
            initRv()
            vm.getData()
        })

        initVM()
        initRv()
        vm.getData()
    }
    private fun initVM(){
        vm.catalog.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
        })
    }
    private fun initRv(){
        binding?.rv1?.adapter = adapter
    }


    private fun toItemActivity(data: Recatalog) {
        val destination = HomeFragmentDirections.actionNavigationHomeToItemFragment2(data)
        findNavController().navigate(destination)
    }

    private fun save(){

    }

}