package com.hofc.hofc

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by maladota on 01/09/2017.
 */
@Module
class ContextModule(val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }
}