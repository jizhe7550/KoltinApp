package com.jizhe7550.kotlinapp.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jizhe7550.kotlinapp.models.AccountProperties
import com.jizhe7550.kotlinapp.models.AuthToken

@Database(entities = [AccountProperties::class, AuthToken::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAuthTokenDao(): AuthTokenDao

    abstract fun getAccountPropertiesDao(): AccountPropertiesDao

    companion object {
        const val DATABASE_NAME: String = "app_db"
    }
}