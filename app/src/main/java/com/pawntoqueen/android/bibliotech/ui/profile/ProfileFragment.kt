package com.pawntoqueen.android.bibliotech.ui.profile

import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pawntoqueen.android.bibliotech.databinding.FragmentProfileBinding
import com.pawntoqueen.android.bibliotech.utils.FragmentUtil

class ProfileFragment : FragmentUtil<ProfileViewModel?, FragmentProfileBinding>() {

    override var viewModel: ProfileViewModel? = null

    override fun prepareView() {
        val textView : TextView = binding.textProfile
        viewModel?.text?.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
    }


}