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

    NavHost(navController = navController, startDestination = "persona_screen") {
        composable("persona_screen") {
            PersonaScreen(navController, personaRepository, cocheRepository)
        }
        composable("coche_screen") {
            ListScreen(navController, cocheRepository, personaRepository) // Asegúrate de pasar personaRepository
        }
    }
}
