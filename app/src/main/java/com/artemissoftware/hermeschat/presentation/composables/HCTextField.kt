package com.artemissoftware.hermeschat.presentation.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.hermeschat.R
import com.artemissoftware.hermeschat.ui.theme.HermesChatTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HCTextField(
    text: String,
    onValueChange: (String) -> Unit,
    @StringRes placeHolder: Int,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .shadow(4.dp, shape = RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .padding(end = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        TextField(
            value = text,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = Color.White,
                containerColor = Color.Transparent,
            ),
            placeholder = {
                Text(text = stringResource(id = placeHolder))
            },
        )
        IconButton(
            onClick = {
                if (text.isNotEmpty()) {
                    onClick.invoke()
                }
            },
            modifier = Modifier
                .size(40.dp)
                .shadow(8.dp, shape = RoundedCornerShape(8.dp))
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.primary),
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HCTextFieldPreview() {
    HermesChatTheme {
        HCTextField(
            modifier = Modifier
                .fillMaxWidth(),
            text = "My text",
            onValueChange = {},
            placeHolder = R.string.app_name,
            icon = Icons.Rounded.ArrowForward,
            onClick = {},
        )
    }
}
