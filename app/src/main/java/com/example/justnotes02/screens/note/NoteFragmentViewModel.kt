package com.example.justnotes02.screens.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ComputableLiveData
import androidx.lifecycle.viewModelScope
import com.example.justnotes02.models.AppNote
import com.example.justnotes02.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteFragmentViewModel(application: Application) : AndroidViewModel(application) {
    fun delete(note: AppNote, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.Main) { REPOSITORY.delete(note, onSuccess) }
    }

}