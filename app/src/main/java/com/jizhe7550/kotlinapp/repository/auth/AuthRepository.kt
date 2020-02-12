package com.jizhe7550.kotlinapp.repository.auth

import com.jizhe7550.kotlinapp.api.auth.OpenApiAuthService
import com.jizhe7550.kotlinapp.persistence.AccountPropertiesDao
import com.jizhe7550.kotlinapp.persistence.AuthTokenDao
import com.jizhe7550.kotlinapp.session.SessionManager

class AuthRepository
constructor(
    val authTokenDao: AuthTokenDao,
    val accountPropertiesDao: AccountPropertiesDao,
    val openApiAuthService: OpenApiAuthService,
    val sessionManager: SessionManager
) {
}