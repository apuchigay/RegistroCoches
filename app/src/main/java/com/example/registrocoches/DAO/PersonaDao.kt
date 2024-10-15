package com.example.registrocoches.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.registrocoches.Model.Persona

@Dao
interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(persona: Persona): Long // Cambia el retorno a Long para el ID

    @Query("SELECT * FROM personas")
    suspend fun getAllPersonas(): List<Persona>

    @Update
    suspend fun update(persona: Persona)

    @Query("SELECT * FROM personas WHERE id = :personaId")
    suspend fun getPersonaById(personaId: Long): Persona?
}