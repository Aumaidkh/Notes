package com.android.notes.repositories

import com.android.notes.data.db.NotesDao
import com.android.notes.data.db.entities.Note
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotesRepository @Inject constructor(private val notesDao: NotesDao) {

    suspend fun createNote(note: Note) = notesDao.insertNote(note)

    suspend fun deleteNote(note: Note) = notesDao.deleteNote(note)

    fun fetchAllNotes() = notesDao.fetchNotes()
}