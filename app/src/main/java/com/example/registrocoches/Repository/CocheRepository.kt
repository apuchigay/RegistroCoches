package com.example.registrocoches.Repository

import com.example.registrocoches.DAO.CocheDao
import com.example.registrocoches.Model.Coche

class CocheRepository(private val cocheDao: CocheDao) {

    suspend fun insert(coche: Coche) {
        cocheDao.insert(coche)
    }

    suspend fun getAllCoches(): List<Coche> {
        return cocheDao.getAllCoches()
    }

}