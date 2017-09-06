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

    override fun onCreate() {
        super.onCreate()

        application = this

    }
}