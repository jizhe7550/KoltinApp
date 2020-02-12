package com.jizhe7550.kotlinapp.ui.auth

import androidx.lifecycle.ViewModel
import com.jizhe7550.kotlinapp.repository.auth.AuthRepository

class AuthViewModel
constructor(
    val authRepository: AuthRepository
) : ViewModel() {

}