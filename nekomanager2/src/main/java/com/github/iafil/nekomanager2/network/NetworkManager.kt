package com.github.iafil.nekomanager2.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManager: NetworkConfiguration() {

    override fun host(host: String) = this.apply {
        this._host = host
    }

    override fun port(port: Int) = this.apply {
        this._port = port
    }

    override fun unsave() = this.apply {
        this._unsave = true
    }

    override fun <T> build(clazz: Class<T>): T {

        val service = Retrofit.Builder()
            .baseUrl(host + port.toString())
            .addConverterFactory(GsonConverterFactory.create())

        if(unsave) service.client(getUnsaveClient())

        return service.build().create(clazz)
    }
}