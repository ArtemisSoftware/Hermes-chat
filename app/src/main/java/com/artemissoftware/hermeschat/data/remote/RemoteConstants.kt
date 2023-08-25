package com.artemissoftware.hermeschat.data.remote

object RemoteConstants {

    private const val IP = "192.168.0.2"
    private const val PORT = "8082"

    const val BASE_URL = "http://$IP:$PORT"
    const val SOCKET_BASE_URL = "ws://$IP:$PORT"
}
