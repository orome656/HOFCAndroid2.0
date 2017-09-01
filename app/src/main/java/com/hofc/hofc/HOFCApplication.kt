package com.hofc.hofc

/**
 * Created by maladota on 01/09/2017.
 */
class HOFCApplication: android.app.Application() {
    companion object {
        var application: android.app.Application? = null;
    }

    var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()

        application = this


    }
}