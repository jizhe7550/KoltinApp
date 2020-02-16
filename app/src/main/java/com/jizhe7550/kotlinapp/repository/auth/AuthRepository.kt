package com.jizhe7550.kotlinapp.repository.auth

import androidx.lifecycle.LiveData
import com.jizhe7550.kotlinapp.api.auth.OpenApiAuthService
import com.jizhe7550.kotlinapp.api.auth.network_responses.LoginResponse
import com.jizhe7550.kotlinapp.api.auth.network_responses.RegistrationResponse
import com.jizhe7550.kotlinapp.persistence.AccountPropertiesDao
import com.jizhe7550.kotlinapp.persistence.AuthTokenDao
import com.jizhe7550.kotlinapp.session.SessionManager
import com.jizhe7550.kotlinapp.util.GenericApiResponse
import javax.inject.Inject

class AuthRepository
@Inject
constructor(
    val authTokenDao: AuthTokenDao,
    val accountPropertiesDao: AccountPropertiesDao,
    val openApiAuthService: OpenApiAuthService,
    val sessionManager: SessionManager
) {

    fun testLoginRequest(email: String, password: String): LiveData<GenericApiResponse<LoginResponse>> {
        return openApiAuthService.login(email, password)
    }

    fun testRegistrationRequest(
        email: String,
        username: String,
        password: String,
        confirmPassword: String
    ): LiveData<GenericApiResponse<RegistrationResponse>>{
        return openApiAuthService.register(email, username, password, confirmPassword)
    }
}