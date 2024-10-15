package com.example.registrocoches

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.registrocoches.DAO.PersonaDao
import com.example.registrocoches.DAO.CocheDao
import com.example.registrocoches.Database.CocheDatabase
import com.example.registrocoches.Repository.PersonaRepository
import com.example.registrocoches.Repository.CocheRepository
import com.example.registrocoches.Screens.Navigation

class MainActivity : ComponentActivity() {
    private lateinit var personaDao: PersonaDao
    private lateinit var cocheDao: CocheDao
    private lateinit var personaRepository: PersonaRepository
    private lateinit var cocheRepository: CocheRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa la base de datos
        val db = CocheDatabase.getDatabase(applicationContext)

        // Inicializa los DAOs
        personaDao = db.personaDao()
        cocheDao = db.cocheDao()

        // Inicializa los repositorios con los DAOs
        personaRepository = PersonaRepository(personaDao)
        cocheRepository = CocheRepository(cocheDao)

        enableEdgeToEdge()
        setContent {
            // Pasa los repositorios a la función Navigation
            Navigation(personaRepository, cocheRepository)
        }
    }
}
