package com.pawntoqueen.android.bibliotech.ui.homepage

import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pawntoqueen.android.bibliotech.databinding.FragmentHomepageBinding
import com.pawntoqueen.android.bibliotech.utils.FragmentUtil

class HomePageFragment : FragmentUtil<HomePageViewModel?, FragmentHomepageBinding>() {
    override var viewModel: HomePageViewModel? = null

    override fun prepareView() {
        val textView : TextView = binding.textHomepage
        viewModel?.text?.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(HomePageViewModel::class.java)
    }

}