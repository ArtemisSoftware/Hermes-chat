package com.artemissoftware.hermeschat.presentation.chat.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.hermeschat.R
import com.artemissoftware.hermeschat.domain.model.Message
import com.artemissoftware.hermeschat.ui.theme.GrayFade
import com.artemissoftware.hermeschat.ui.theme.HermesChatTheme
import com.artemissoftware.hermeschat.ui.theme.Pink

@Composable
fun MessageBalloon(
    isOwnMessage: Boolean,
    message: Message,
    modifier: Modifier = Modifier,
) {
    val backgroundColor = if (isOwnMessage) Pink else MaterialTheme.colorScheme.secondary
    val usernameColor = if (isOwnMessage) GrayFade else Color.Gray

    Column(
        modifier = modifier
            .drawBehind {
                balloon(isOwnMessage, backgroundColor = backgroundColor)
            }
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(10.dp),
            )
            .padding(8.dp),
    ) {
        Text(
            text = if (isOwnMessage) stringResource(id = R.string.you) else message.username,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = usernameColor,
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = message.text,
            color = Color.White,
        )
        Text(
            text = message.formattedTime,
            color = Color.White,
            modifier = Modifier.align(Alignment.End),
        )
    }
}

private fun DrawScope.balloon(
    isOwnMessage: Boolean,
    backgroundColor: Color,
) {
    val cornerRadius = 10.dp.toPx()
    val triangleHeight = 20.dp.toPx()
    val triangleWidth = 25.dp.toPx()

    val trianglePath = Path().apply {
        if (isOwnMessage) {
            moveTo(size.width, size.height - cornerRadius)
            lineTo(size.width, size.height + triangleHeight)
            lineTo(size.width - triangleWidth, size.height - cornerRadius)
            close()
        } else {
            moveTo(0f, size.height - cornerRadius)
            lineTo(0f, size.height + triangleHeight)
            lineTo(triangleWidth, size.height - cornerRadius)
            close()
        }
    }
    drawPath(
        path = trianglePath,
        color = backgroundColor,
    )
}

@Preview(showBackground = true)
@Composable
private fun MessageBalloon_isOwnMessage_true_Preview() {
    HermesChatTheme {
        MessageBalloon(
            isOwnMessage = true,
            message = Message(
                text = "First message",
                formattedTime = "12-03-2009",
                username = "username",
            ),
            modifier = Modifier
                .width(200.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MessageBalloon_isOwnMessage_false_Preview() {
    HermesChatTheme {
        Column(modifier = Modifier.fillMaxWidth()) {
            MessageBalloon(
                isOwnMessage = false,
                message = Message(
                    text = "First message",
                    formattedTime = "12-03-2009",
                    username = "username",
                ),
                modifier = Modifier
                    .width(200.dp),
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
