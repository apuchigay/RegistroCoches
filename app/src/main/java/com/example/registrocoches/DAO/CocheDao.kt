package com.example.registrocoches.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.registrocoches.Model.Coche

@Dao
interface CocheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(coche: Coche)

    @Query("SELECT * FROM coches WHERE persona_id = :personaId")
    suspend fun getCochesByPersonaId(personaId: Int): List<Coche>

    @Query("SELECT * FROM coches")  // Añadido: consulta para obtener todos los coches
    suspend fun getAllCoches(): List<Coche>

    @Update
    suspend fun update(coche: Coche)

    @Delete
    suspend fun delete(coche: Coche)
}