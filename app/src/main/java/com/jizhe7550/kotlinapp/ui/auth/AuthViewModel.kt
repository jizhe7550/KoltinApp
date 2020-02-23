package com.jizhe7550.kotlinapp.ui.auth

import androidx.lifecycle.*
import com.jizhe7550.kotlinapp.models.AuthToken
import com.jizhe7550.kotlinapp.repository.auth.AuthRepository
import com.jizhe7550.kotlinapp.ui.BaseViewModel
import com.jizhe7550.kotlinapp.ui.DataState
import com.jizhe7550.kotlinapp.ui.auth.state.AuthStateEvent
import com.jizhe7550.kotlinapp.ui.auth.state.AuthStateEvent.*
import com.jizhe7550.kotlinapp.ui.auth.state.AuthViewState
import com.jizhe7550.kotlinapp.ui.auth.state.LoginFields
import com.jizhe7550.kotlinapp.ui.auth.state.RegistrationFields
import com.jizhe7550.kotlinapp.util.AbsentLiveData
import javax.inject.Inject

class AuthViewModel
@Inject
constructor(
    private val authRepository: AuthRepository
) : BaseViewModel<AuthStateEvent, AuthViewState>() {

    override fun handleStateEvent(stateEvent: AuthStateEvent): LiveData<DataState<AuthViewState>> {
        when (stateEvent) {

            is LoginAttemptEvent -> {
                return authRepository.attemptLogin(
                    stateEvent.email,
                    stateEvent.password
                )
            }

            is RegisterAttemptEvent -> {
                return authRepository.attemptRegistration(
                    stateEvent.email,
                    stateEvent.username,
                    stateEvent.password,
                    stateEvent.confirm_password
                )
            }

            is CheckPreviousAuthEvent -> {
                return authRepository.checkPreviousAuthUser()
            }

            else -> {
                return AbsentLiveData.create()
            }
        }
    }

    override fun initNewViewState(): AuthViewState {
        return AuthViewState()
    }

    fun setRegistrationFields(registrationFields: RegistrationFields) {
        val update = getCurrentViewStateOrNew()
        if (update.registrationFields == registrationFields) {
            return
        }
        update.registrationFields = registrationFields
        setViewState(update)
    }

    fun setLoginFields(loginFields: LoginFields) {
        val update = getCurrentViewStateOrNew()
        if (update.loginFields == loginFields) {
            return
        }
        update.loginFields = loginFields
        setViewState(update)
    }

    fun setAuthToken(authToken: AuthToken) {
        val update = getCurrentViewStateOrNew()
        if (update.authToken == authToken) {
            return
        }
        update.authToken = authToken
        setViewState(update)
    }

    fun cancelActiveJobs() {
        authRepository.cancelActiveJobs()
    }


    override fun onCleared() {
        super.onCleared()
        cancelActiveJobs()
    }
}
