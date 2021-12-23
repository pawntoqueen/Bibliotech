package com.pawntoqueen.android.bibliotech.ui.recentlybooks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecentlyBooksViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is RecentlyBooks Fragment"
    }
    val text: LiveData<String> = _text
}