package com.example.registrocoches.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier

@Composable
fun PersonaScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Formulario de Personas")
        // Aquí puedes añadir más campos para el formulario

        Button(onClick = { navController.navigate("coche_screen") }) {
            Text(text = "Ir al formulario de Coches")
        }
    }
}