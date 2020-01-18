package com.github.iafil.nekomanager2.network

import android.annotation.SuppressLint
import okhttp3.OkHttpClient
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

@Suppress("PropertyName", "SpellCheckingInspection")
abstract class NetworkConfiguration {

    protected var _host: String = ""
    protected val host: String
        get() = _host

    protected var _port: Int = 80
    protected val port: Int
        get() = _port

    protected var _unsave: Boolean = false
    protected val unsave: Boolean
        get() = _unsave

    abstract fun host(host: String): NetworkConfiguration

    abstract fun port(port: Int): NetworkConfiguration

    abstract fun unsave(): NetworkConfiguration

    abstract fun <T> build(clazz: Class<T>): T

    protected fun getUnsaveClient(): OkHttpClient = try {

        val ca = object : X509TrustManager {
            @SuppressLint("TrustAllX509TrustManager")
            override fun checkClientTrusted(
                chain: Array<out X509Certificate>?,
                authType: String?
            ) {
            }

            @SuppressLint("TrustAllX509TrustManager")
            override fun checkServerTrusted(
                chain: Array<out X509Certificate>?,
                authType: String?
            ) {
            }

            override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()

        }

        val ctx = SSLContext.getInstance("SSL")
        ctx.init(null, arrayOf(ca), SecureRandom())

        OkHttpClient.Builder()
            .sslSocketFactory(ctx.socketFactory, ca as X509TrustManager)
            .hostnameVerifier { _, _ -> true }
            .build()

    } catch (e: Exception) {
        throw RuntimeException(e)
    }
}