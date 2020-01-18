package com.github.iafil.nekomanager2.test

import com.github.iafil.nekomanager2.network.NetworkManager

class NetworkTest {

    fun test() {
        val service = NetworkManager()
            .host("")
            .port(1)
            .unsave()
            .build(Remote::class.java)
    }

    interface Remote {

        fun login()
    }
}