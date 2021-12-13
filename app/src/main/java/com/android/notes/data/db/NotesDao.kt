package com.android.notes.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.notes.data.db.entities.Note

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM notes_table")
    fun fetchNotes(): LiveData<List<Note>>

}