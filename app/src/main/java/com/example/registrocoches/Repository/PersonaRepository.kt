package com.example.registrocoches.Repository

import com.example.registrocoches.DAO.PersonaDao
import com.example.registrocoches.Model.Persona

class PersonaRepository(private val personaDao: PersonaDao) {

    suspend fun insert(persona: Persona): Long { // Cambia el retorno a Long para el ID
        return personaDao.insert(persona)
    }

    suspend fun getAllPersonas(): List<Persona> {
        return personaDao.getAllPersonas()
    }

    // Define la función para obtener una persona por ID
    suspend fun getPersonaById(personaId: Long): Persona? {
        return personaDao.getPersonaById(personaId)
    }
}
