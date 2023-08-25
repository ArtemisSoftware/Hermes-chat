package com.artemissoftware.hermeschat.data.remote.service

import com.artemissoftware.hermeschat.data.remote.RemoteConstants.BASE_URL
import com.artemissoftware.hermeschat.domain.model.Message

interface MessageService {

    suspend fun getAllMessages(): List<Message>

    sealed class Endpoints(val url: String) {
        object GetAllMessages : Endpoints("$BASE_URL/messages")
    }
}
