package com.example.registrocoches.Repository

import com.example.registrocoches.DAO.PersonaDao
import com.example.registrocoches.Model.Persona

class PersonaRepository(private val personaDao: PersonaDao) {

    suspend fun insert(persona: Persona) {
        personaDao.insert(persona)
    }

    suspend fun getAllPersonas(): List<Persona> {
        return personaDao.getAllPersonas()
    }

}