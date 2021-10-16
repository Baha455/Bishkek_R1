package com.example.bishkekrielt.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bishkekrielt.databinding.FragmentNotificationsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NotificationsFragment : Fragment() {

    var binding: FragmentNotificationsBinding? = null
    private val vm by viewModel<NotificationsViewModel>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNotificationsBinding.inflate(layoutInflater)
        return  binding?.root
    }
}