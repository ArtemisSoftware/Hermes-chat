package com.artemissoftware.hermeschat.presentation.chat

import com.artemissoftware.hermeschat.domain.model.Message

data class ChatState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false,
)
