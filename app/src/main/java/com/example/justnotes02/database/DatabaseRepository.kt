package com.example.justnotes02.database

import androidx.lifecycle.LiveData
import com.example.justnotes02.models.AppNote

interface DatabaseRepository {
    val allNotes: LiveData<List<AppNote>>

    suspend fun insert(note: AppNote, onSuccess: () -> Unit)
    suspend fun delete(note: AppNote, onSuccess: () -> Unit)

}