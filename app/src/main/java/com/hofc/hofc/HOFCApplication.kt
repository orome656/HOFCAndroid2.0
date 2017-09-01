package com.hofc.hofc

import android.content.Context

/**
 * Created by maladota on 01/09/2017.
 */
class HOFCApplication: android.app.Application() {
    companion object {
        var application: android.app.Application? = null;

        fun app(): android.app.Application? {
            return application;
        }
    }

    var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()

        application = this

        appComponent = DaggerAppComponent.builder()
                .contextModule(ContextModule(applicationContext))
                .appModule(AppModule())
                .build()
    }
}