package com.example.registrocoches.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.registrocoches.Model.Coche
import com.example.registrocoches.Model.Persona
import com.example.registrocoches.Repository.CocheRepository
import com.example.registrocoches.Repository.PersonaRepository
import kotlinx.coroutines.launch
import android.widget.Toast
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext

@Composable
fun PersonaScreen(
    navController: NavController,
    personaRepository: PersonaRepository,
    cocheRepository: CocheRepository
) {
    var nombre by remember { mutableStateOf("") }
    var apellido1 by remember { mutableStateOf("") }
    var apellido2 by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }
    var marca by remember { mutableStateOf("") }
    var matricula by remember { mutableStateOf("") }
    var caballos by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Formulario de Personas y Coches", style = MaterialTheme.typography.headlineMedium)

        // Campos del formulario
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = apellido1,
            onValueChange = { apellido1 = it },
            label = { Text("Apellido 1") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = apellido2,
            onValueChange = { apellido2 = it },
            label = { Text("Apellido 2") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = dni,
            onValueChange = { dni = it },
            label = { Text("DNI") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = marca,
            onValueChange = { marca = it },
            label = { Text("Marca del coche") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = matricula,
            onValueChange = { matricula = it },
            label = { Text("Matrícula del coche") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = caballos,
            onValueChange = { caballos = it },
            label = { Text("Caballos del coche") },
            modifier = Modifier.fillMaxWidth()
        )

        // Botón de guardar
        Button(onClick = {
            // Validar y guardar datos
            coroutineScope.launch {
                // Guardar Persona
                val persona = Persona(nombre = nombre, apellido1 = apellido1, apellido2 = apellido2, dni = dni)
                val personaId = personaRepository.insert(persona) // Ahora obtenemos el ID al insertar

                // Guardar Coche
                val coche = Coche(matricula = matricula, marca = marca, caballos = caballos.toInt(), persona_id = personaId)
                cocheRepository.insert(coche) // Aquí ahora obtenemos el ID del coche insertado

                // Mostrar un mensaje de confirmación
                Toast.makeText(context, "Datos guardados con éxito", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Guardar")
        }

        // Botón de navegación
        Button(onClick = { navController.navigate("coche_screen") }) {
            Text(text = "Ir al listado de datos")
        }
    }
}
