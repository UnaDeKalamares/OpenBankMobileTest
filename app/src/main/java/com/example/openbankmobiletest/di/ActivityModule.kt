package com.example.openbankmobiletest.di

import com.example.openbankmobiletest.detail.DetailActivity
import com.example.openbankmobiletest.master.view.MasterActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun provideMasterActivity() : MasterActivity

    @ContributesAndroidInjector
    abstract fun providesDetailActivity() : DetailActivity

}