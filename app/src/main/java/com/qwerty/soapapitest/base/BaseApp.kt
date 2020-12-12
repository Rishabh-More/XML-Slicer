package com.qwerty.soapapitest.base

import android.app.Application
import com.qwerty.soapapitest.BuildConfig
import com.qwerty.soapapitest.codebase.dependencies.restClassModule
import com.qwerty.soapapitest.codebase.dependencies.soapClassModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApp)
            modules(listOf(restClassModule, soapClassModule))
        }

        //Plant a timber Tree
        if(BuildConfig.DEBUG){
            Timber.plant(DebugTree())
        }
    }
}