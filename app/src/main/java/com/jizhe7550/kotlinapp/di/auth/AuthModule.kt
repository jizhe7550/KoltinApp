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

    @AuthScope
    @Provides
    fun provideFakeApiService(retrofitBuilder: Retrofit.Builder): OpenApiAuthService {
        return retrofitBuilder
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