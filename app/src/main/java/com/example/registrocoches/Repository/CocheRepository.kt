package com.example.registrocoches.Repository

import com.example.registrocoches.DAO.CocheDao
import com.example.registrocoches.Model.Coche

class CocheRepository(private val cocheDao: CocheDao) {

    suspend fun insert(coche: Coche): Long { // Cambiado para devolver el ID
        return cocheDao.insert(coche)
    }

    suspend fun getAllCoches(): List<Coche> {
        return cocheDao.getAllCoches() // Este es el metodo del dao
    }
}
