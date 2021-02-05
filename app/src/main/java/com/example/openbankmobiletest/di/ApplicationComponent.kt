package com.example.openbankmobiletest.di

import com.example.openbankmobiletest.MarvelApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, NetModule::class, ActivityModule::class])
interface ApplicationComponent : AndroidInjector<MarvelApp> {

    override fun inject(instance: MarvelApp?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MarvelApp): Builder
        fun build(): ApplicationComponent
    }

}