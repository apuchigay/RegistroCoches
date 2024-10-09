package com.example.registrocoches.Database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.registrocoches.DAO.PersonaDao

abstract class PersonaDatabase :RoomDatabase() {
    abstract fun personaDao(): PersonaDao

    companion object {
        @Volatile
        private var INSTANCE: PersonaDatabase? = null

        fun getDatabase(context: Context): PersonaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonaDatabase::class.java,
                    "persona_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}