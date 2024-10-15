package com.example.registrocoches.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.registrocoches.Model.Coche
import com.example.registrocoches.Model.Persona
import com.example.registrocoches.Repository.CocheRepository
import com.example.registrocoches.Repository.PersonaRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavController,
    cocheRepository: CocheRepository,
    personaRepository: PersonaRepository
) {
    var coches by remember { mutableStateOf<List<Coche>>(emptyList()) }

    // Usamos LaunchedEffect para cargar los coches de manera asíncrona
    LaunchedEffect(Unit) {
        coches = cocheRepository.getAllCoches() // Asegúrate de que esta función sea suspendida
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Listado de Coches") },
                actions = {
                    IconButton(onClick = { navController.navigate("main_screen") }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(coches) { coche ->
                // LaunchedEffect para cargar la persona asociada al coche de manera asíncrona
                var persona by remember { mutableStateOf<Persona?>(null) }
                LaunchedEffect(coche.persona_id) {
                    persona = personaRepository.getPersonaById(coche.persona_id)
                }

                CochePersonaCard(coche = coche, persona = persona) // Asegúrate de que esté definido
            }
        }
    }
}


@Composable
fun CochePersonaCard(coche: Coche, persona: Persona?) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Muestra los datos de la persona si están disponibles
            persona?.let {
                Text(text = "Nombre: ${it.nombre}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Apellido: ${it.apellido1}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Apellido: ${it.apellido2}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "DNI: ${it.dni}", style = MaterialTheme.typography.bodyMedium)
            }

            Text(text = "Marca: ${coche.marca}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Matrícula: ${coche.matricula}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Caballos: ${coche.caballos}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Persona ID: ${coche.persona_id}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}