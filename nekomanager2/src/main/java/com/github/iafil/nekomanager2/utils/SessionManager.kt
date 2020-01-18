package com.github.iafil.nekomanager2.utils

import android.content.Context

class SessionManager(context: Context, prefName: String) {

    private val preferences = context.getSharedPreferences(prefName, 0)
    private val editor = preferences.edit()

    fun set(key: String, value: Any?) {
        when(value) {
            is String -> editor.putString(key, value)
            is Int -> editor.putInt(key, value)
            is Float -> editor.putFloat(key, value)
            is Long -> editor.putLong(key, value)
            is Boolean -> editor.putBoolean(key, value)
        }
        editor.apply()
    }

    fun clear() {
        editor.clear()
        editor.apply()
    }

    fun getString(key: String) = preferences.getString(key, "") ?: ""

    fun getInt(key: String) = preferences.getInt(key, 0)

    fun getFloat(key: String) = preferences.getFloat(key, 0f)

    fun getLong(key: String) = preferences.getLong(key, 0L)

    fun getBoolean(key: String) = preferences.getBoolean(key, false)

    fun isLogin() = preferences.getBoolean(LOGIN_KEY, false)

    fun login() = set(LOGIN_KEY, true)

    fun logout() = clear()

    companion object {

        private const val LOGIN_KEY = ":::Login-KEY:::"
    }
}