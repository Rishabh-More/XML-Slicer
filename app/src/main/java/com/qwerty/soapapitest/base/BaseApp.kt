package com.qwerty.soapapitest.base

import android.app.Application
import com.qwerty.soapapitest.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        //Plant a timber Tree
        if(BuildConfig.DEBUG){
            Timber.plant(DebugTree())
        }
    }
}