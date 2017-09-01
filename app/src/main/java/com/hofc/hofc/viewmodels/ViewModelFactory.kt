package com.hofc.hofc.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * Created by Anthony on 01/09/2017.
 */
class ViewModelFactory @Inject constructor(val viewModel: ViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>?): T {
        if(modelClass?.isAssignableFrom(ActusListViewModel::class.java) == true) {
            return viewModel as T
        }

        throw IllegalArgumentException("Unknown class name")
    }
}