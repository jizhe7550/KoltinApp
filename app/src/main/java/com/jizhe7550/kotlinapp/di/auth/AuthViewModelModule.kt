package com.jizhe7550.kotlinapp.di.auth

import androidx.lifecycle.ViewModel
import com.jizhe7550.kotlinapp.di.ViewModelKey
import com.jizhe7550.kotlinapp.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel

}