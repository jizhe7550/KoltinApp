package com.jizhe7550.kotlinapp.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jizhe7550.kotlinapp.api.auth.network_responses.LoginResponse
import com.jizhe7550.kotlinapp.api.auth.network_responses.RegistrationResponse
import com.jizhe7550.kotlinapp.repository.auth.AuthRepository
import com.jizhe7550.kotlinapp.util.GenericApiResponse
import javax.inject.Inject

class AuthViewModel
@Inject
constructor(
    val authRepository: AuthRepository
) : ViewModel() {
    
    fun testLogin(): LiveData<GenericApiResponse<LoginResponse>> {
        return authRepository.testLoginRequest(
            "mitchelltabian@gmail.com",
            "codingwithmitch1"
        )
    }

    fun testRegister(): LiveData<GenericApiResponse<RegistrationResponse>> {
        return authRepository.testRegistrationRequest(
            "mitchelltabian1234@gmail.com",
            "mitchelltabian1234",
            "codingwithmitch1",
            "codingwithmitch1"
        )
    }
}