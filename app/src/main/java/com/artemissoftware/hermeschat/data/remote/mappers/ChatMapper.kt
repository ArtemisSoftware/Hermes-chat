package com.artemissoftware.hermeschat.data.remote.mappers

import com.artemissoftware.hermeschat.data.remote.dto.MessageDto
import com.artemissoftware.hermeschat.domain.model.Message
import java.text.DateFormat
import java.util.Date

fun MessageDto.toMessage(): Message {
    val date = Date(timestamp)
    val formattedDate = DateFormat
        .getDateInstance(DateFormat.DEFAULT)
        .format(date)

    return Message(
        text = text,
        formattedTime = formattedDate,
        username = username,
    )
}
