package com.android.notes.data.db


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.notes.data.db.entities.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
//@TypeConverters(Converters::class)
abstract class NotesDatabase: RoomDatabase() {

    abstract fun getNotesDao(): NotesDao


}