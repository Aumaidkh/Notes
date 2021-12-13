package com.android.notes.ui.features.home

import androidx.lifecycle.*
import com.android.notes.data.db.entities.Note
import com.android.notes.repositories.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor (private val repository: NotesRepository): ViewModel() {

    var notesLiveData: MutableLiveData<List<Note>> = MutableLiveData()

    fun getNotes(): LiveData<List<Note>> {
        return repository.fetchAllNotes()
    }

    fun createNote(note: Note){
        viewModelScope.launch {
            repository.createNote(note)
        }
    }

    fun deleteNote(note: Note){
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }

}