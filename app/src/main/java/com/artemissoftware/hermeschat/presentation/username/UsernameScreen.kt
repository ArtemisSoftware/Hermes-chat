package com.artemissoftware.hermeschat.presentation.username

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.artemissoftware.hermeschat.R
import com.artemissoftware.hermeschat.presentation.composables.HCTextField
import com.artemissoftware.hermeschat.presentation.username.composables.Logo
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsernameScreen(
    viewModel: UsernameViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit,
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    LaunchedEffect(key1 = true) {
        viewModel.onJoinChat.collectLatest { username ->
            onNavigate("chat_screen/$username")
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Logo(
                infiniteTransition = infiniteTransition,
                modifier = Modifier
                    .padding(12.dp)
                    .size(120.dp),
            )

            Spacer(modifier = Modifier.height(28.dp))

            HCTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                text = viewModel.usernameText.value,
                onValueChange = viewModel::onUsernameChange,
                placeHolder = R.string.enter_username,
                icon = Icons.Rounded.ArrowForward,
                onClick = viewModel::onJoinClick,
            )
        }
    }
}
