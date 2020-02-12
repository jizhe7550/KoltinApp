package com.jizhe7550.kotlinapp.session

import android.app.Application
import com.jizhe7550.kotlinapp.persistence.AuthTokenDao

class SessionManager
constructor(
    val authTokenDao: AuthTokenDao,
    val application: Application
){
}