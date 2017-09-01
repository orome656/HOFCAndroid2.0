package com.hofc.hofc

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.hofc.hofc.di.ViewModelKey
import com.hofc.hofc.viewmodels.ActusListViewModel
import com.hofc.hofc.viewmodels.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Anthony on 01/09/2017.
 */
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ActusListViewModel::class)
    abstract fun bindActuListViewModel(actusListViewModel: ActusListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}