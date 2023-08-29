package com.artemissoftware.hermeschat.data.remote

object RemoteConstants {

    private const val IP = "192.168.1.91"
    private const val PORT = "8081"

    const val BASE_URL = "http://$IP:$PORT"
    const val SOCKET_BASE_URL = "ws://$IP:$PORT"
}
