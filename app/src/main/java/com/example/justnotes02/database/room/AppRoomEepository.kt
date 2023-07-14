package com.example.justnotes02.database.room

import androidx.lifecycle.LiveData
import com.example.justnotes02.database.DatabaseRepository
import com.example.justnotes02.models.AppNote

class AppRoomRepository(val dao: AppRoomDao):DatabaseRepository {
    override val allNotes: LiveData<List<AppNote>>
        get() = dao.getAllNotes()

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        dao.insert(note)
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        dao.delete(note)
    }
}