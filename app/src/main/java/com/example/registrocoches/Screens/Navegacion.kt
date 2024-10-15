package com.example.registrocoches.Screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.registrocoches.Repository.CocheRepository
import com.example.registrocoches.Repository.PersonaRepository

@Composable
fun Navigation(personaRepository: PersonaRepository, cocheRepository: CocheRepository) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main_screen") {
        composable("main_screen") {
            MainScreen(navController, personaRepository, cocheRepository)
        }
        composable("list_screen") {
            ListScreen(navController, cocheRepository, personaRepository) // Asegúrate de pasar personaRepository
        }
    }
}
