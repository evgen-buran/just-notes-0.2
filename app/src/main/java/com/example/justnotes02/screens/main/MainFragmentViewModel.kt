package com.example.justnotes02.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.justnotes02.models.AppNote
import com.example.justnotes02.utils.REPOSITORY

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val allNotes:LiveData<List<AppNote>> = REPOSITORY.allNotes
}