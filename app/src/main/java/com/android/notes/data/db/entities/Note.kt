package com.android.notes.data.db.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.android.notes.data.db.Converters


@Entity(
    tableName = "notes_table"
)
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "title")
    var note_title: String? = null,

    @ColumnInfo(name = "desc")
    var note_body: String? = null,

//    @TypeConverters(Converters::class)
    @ColumnInfo(name = "tasks")
    var tasks:  List<TodoItem>? = null
)


