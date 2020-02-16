package com.jizhe7550.kotlinapp.di.auth

import com.jizhe7550.kotlinapp.ui.auth.ForgotPasswordFragment
import com.jizhe7550.kotlinapp.ui.auth.LauncherFragment
import com.jizhe7550.kotlinapp.ui.auth.LoginFragment
import com.jizhe7550.kotlinapp.ui.auth.RegisterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AuthFragmentBuildersModule {

    @ContributesAndroidInjector()
    abstract fun contributeLauncherFragment(): LauncherFragment

    @ContributesAndroidInjector()
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector()
    abstract fun contributeRegisterFragment(): RegisterFragment

    @ContributesAndroidInjector()
    abstract fun contributeForgotPasswordFragment(): ForgotPasswordFragment

}