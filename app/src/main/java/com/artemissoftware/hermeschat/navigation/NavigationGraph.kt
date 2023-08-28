package com.artemissoftware.hermeschat.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.artemissoftware.hermeschat.presentation.chat.ChatScreen
import com.artemissoftware.hermeschat.presentation.username.UsernameScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "username_screen",
    ) {
        composable("username_screen") {
            UsernameScreen(onNavigate = navController::navigate)
        }
        composable(
            route = "chat_screen/{username}",
            arguments = listOf(
                navArgument(name = "username") {
                    type = NavType.StringType
                    nullable = true
                },
            ),
        ) {
            val username = it.arguments?.getString("username")
            ChatScreen(username = username)
        }
    }
}
