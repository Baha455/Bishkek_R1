package com.example.bishkekrielt.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bishkekrielt.R
import com.example.bishkekrielt.data.common.BaseFragment
import com.example.bishkekrielt.databinding.FragmentHomeBinding
import com.example.bishkekrielt.databinding.FragmentNotificationsBinding
import com.example.bishkekrielt.ui.dashboard.DashboardViewModel
import com.example.bishkekrielt.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NotificationsFragment : Fragment() {

    var binding: FragmentNotificationsBinding? = null
    private val vm by viewModel<NotificationsViewModel>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNotificationsBinding.inflate(layoutInflater)
        return  binding?.root
    }
}