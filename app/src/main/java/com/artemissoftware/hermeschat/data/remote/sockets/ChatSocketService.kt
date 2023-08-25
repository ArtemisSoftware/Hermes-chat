package com.artemissoftware.hermeschat.data.remote.sockets

import com.artemissoftware.hermeschat.data.remote.RemoteConstants.SOCKET_BASE_URL
import com.artemissoftware.hermeschat.domain.model.Message
import com.artemissoftware.hermeschat.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(username: String): Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages(): Flow<Message>

    suspend fun closeSession()

    sealed class Endpoints(val url: String) {
        object ChatSocket : Endpoints("$SOCKET_BASE_URL/chat-socket")
    }
}
