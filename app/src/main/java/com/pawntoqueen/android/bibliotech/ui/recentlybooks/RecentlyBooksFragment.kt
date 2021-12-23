package com.pawntoqueen.android.bibliotech.ui.recentlybooks

import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pawntoqueen.android.bibliotech.databinding.FragmentRecentlyBooksBinding
import com.pawntoqueen.android.bibliotech.utils.FragmentUtil


class RecentlyBooksFragment : FragmentUtil<RecentlyBooksViewModel?, FragmentRecentlyBooksBinding>() {

    override var viewModel: RecentlyBooksViewModel? = null

    override fun prepareView() {
        val textView : TextView = binding.textRecentlybooks
        viewModel?.text?.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(RecentlyBooksViewModel::class.java)
    }


}