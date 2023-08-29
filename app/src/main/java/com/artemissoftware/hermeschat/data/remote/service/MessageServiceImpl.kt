package com.artemissoftware.hermeschat.data.remote.service

import com.artemissoftware.hermeschat.data.remote.dto.MessageDto
import com.artemissoftware.hermeschat.data.remote.mappers.toMessage
import com.artemissoftware.hermeschat.domain.model.Message
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MessageServiceImpl(
    private val client: HttpClient,
) : MessageService {

    override suspend fun getAllMessages(): List<Message> {
        return try {
            val messages = client.get(MessageService.Endpoints.GetAllMessages.url).body<List<MessageDto>>()
            messages.map { it.toMessage() }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
