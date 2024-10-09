package com.example.registrocoches.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.registrocoches.DAO.CocheDao
import com.example.registrocoches.DAO.PersonaDao
import com.example.registrocoches.Model.Coche
import com.example.registrocoches.Model.Persona

@Database(entities = [Coche::class, Persona::class], version = 1, exportSchema = false)
abstract class CocheDatabase : RoomDatabase() {
    abstract fun cocheDao(): CocheDao
    abstract fun personaDao(): PersonaDao

    companion object {
        @Volatile
        private var INSTANCE: CocheDatabase? = null

        fun getDatabase(context: Context): CocheDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CocheDatabase::class.java,
                    "coche_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}