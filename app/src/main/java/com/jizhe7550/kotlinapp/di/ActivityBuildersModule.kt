package com.jizhe7550.kotlinapp.di

import com.jizhe7550.kotlinapp.di.auth.AuthFragmentBuildersModule
import com.jizhe7550.kotlinapp.di.auth.AuthModule
import com.jizhe7550.kotlinapp.di.auth.AuthScope
import com.jizhe7550.kotlinapp.di.auth.AuthViewModelModule
import com.jizhe7550.kotlinapp.di.main.MainFragmentBuildersModule
import com.jizhe7550.kotlinapp.di.main.MainModule
import com.jizhe7550.kotlinapp.di.main.MainScope
import com.jizhe7550.kotlinapp.di.main.MainViewModelModule
import com.jizhe7550.kotlinapp.ui.auth.AuthActivity
import com.jizhe7550.kotlinapp.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = [AuthModule::class, AuthFragmentBuildersModule::class, AuthViewModelModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity

    @MainScope
    @ContributesAndroidInjector(
        modules = [MainModule::class, MainFragmentBuildersModule::class, MainViewModelModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}