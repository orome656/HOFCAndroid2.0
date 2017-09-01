package com.hofc.hofc

import com.hofc.hofc.fragments.ActusListFragment
import com.hofc.hofc.repositories.ActuRepository
import dagger.Component
import javax.inject.Singleton

/**
 * Created by maladota on 01/09/2017.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, ContextModule::class))
interface AppComponent {
    fun actuRepository(): ActuRepository
    fun inject(actuListFragment: ActusListFragment)
}