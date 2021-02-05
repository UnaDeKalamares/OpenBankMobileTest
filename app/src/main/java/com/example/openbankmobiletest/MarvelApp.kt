package com.example.openbankmobiletest

import com.example.openbankmobiletest.di.ApplicationComponent
import com.example.openbankmobiletest.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MarvelApp : DaggerApplication() {

    lateinit var appComponent: ApplicationComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        appComponent = DaggerApplicationComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent

    }

}