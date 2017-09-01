package com.hofc.hofc

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by maladota on 01/09/2017.
 */
@Singleton
@Module
class ContextModule(val context: Context) {
    @Provides
    @Singleton
    fun provideContext(): Context {
        return context
    }
}