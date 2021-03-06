package com.example.bishkekrielt.ui.home
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bishkekrielt.data.model.Recatalog
import com.example.bishkekrielt.databinding.FragmentHomeBinding
import com.example.bishkekrielt.ui.adapter.RvAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(){

    var binding: FragmentHomeBinding? = null
    private val vm by viewModel<HomeViewModel>()
    private val adapter by lazy { RvAdapter() {
        toItemActivity(it)} }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return  binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVM()
        initRv()
        vm.getData()
        }



    private fun initVM(){
        vm.catalog.observe(viewLifecycleOwner, {
            adapter.updateData(it)
        })
    }
    private fun initRv(){
        binding?.rv1?.adapter = adapter
    }


    private fun toItemActivity(data: Recatalog) {
        val destination = HomeFragmentDirections.actionHomeFragmentToItemFragment(data)
        findNavController().navigate(destination)
    }

}