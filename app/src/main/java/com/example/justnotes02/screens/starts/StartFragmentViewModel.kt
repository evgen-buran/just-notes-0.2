package com.example.justnotes02.screens.starts

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.justnotes02.database.room.AppRoomDatabase
import com.example.justnotes02.database.room.AppRoomRepository
import com.example.justnotes02.utils.REPOSITORY
import com.example.justnotes02.utils.TYPE_ROOM

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val context: Context = application
    fun initDatabase(type: String, onSuccess: () -> Unit) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
        }


    }

}