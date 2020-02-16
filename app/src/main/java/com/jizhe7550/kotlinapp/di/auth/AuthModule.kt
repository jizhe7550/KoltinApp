package com.jizhe7550.kotlinapp.di.auth

import com.jizhe7550.kotlinapp.api.auth.OpenApiAuthService
import com.jizhe7550.kotlinapp.persistence.AccountPropertiesDao
import com.jizhe7550.kotlinapp.persistence.AuthTokenDao
import com.jizhe7550.kotlinapp.repository.auth.AuthRepository
import com.jizhe7550.kotlinapp.session.SessionManager
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule{

    // TEMPORARY
    @AuthScope
    @Provides
    fun provideFakeApiService(): OpenApiAuthService {
        return Retrofit.Builder()
            .baseUrl("https://open-api.xyz")
            .build()
            .create(OpenApiAuthService::class.java)
    }

    @AuthScope
    @Provides
    fun provideAuthRepository(
        sessionManager: SessionManager,
        authTokenDao: AuthTokenDao,
        accountPropertiesDao: AccountPropertiesDao,
        openApiAuthService: OpenApiAuthService
    ): AuthRepository {
        return AuthRepository(
            authTokenDao,
            accountPropertiesDao,
            openApiAuthService,
            sessionManager
        )
    }

}