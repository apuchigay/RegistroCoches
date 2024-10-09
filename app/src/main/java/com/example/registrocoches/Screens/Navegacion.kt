package com.example.registrocoches.Screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "persona_screen") {
        composable("persona_screen") {
            PersonaScreen(navController)
        }
        composable("coche_screen") {
            CocheScreen(navController)
        }
    }
}