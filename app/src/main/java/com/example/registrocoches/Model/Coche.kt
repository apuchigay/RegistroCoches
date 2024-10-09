package com.example.registrocoches.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "coches",
    foreignKeys = [
        ForeignKey(
            entity = Persona::class,
            parentColumns = ["id"],
            childColumns = ["persona_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Coche(
    @PrimaryKey(autoGenerate = false)
    val matricula: String,
    val marca: String,
    val caballos: Int,
    val persona_id: Int
)