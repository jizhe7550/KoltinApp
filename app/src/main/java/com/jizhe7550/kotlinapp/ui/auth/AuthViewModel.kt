package com.jizhe7550.kotlinapp.ui.auth

import androidx.lifecycle.ViewModel
import com.jizhe7550.kotlinapp.repository.auth.AuthRepository
import javax.inject.Inject

class AuthViewModel
@Inject
constructor(
    val authRepository: AuthRepository
) : ViewModel() {

}