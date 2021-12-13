package com.android.notes.data.db.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


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

//    @ColumnInfo(name = "tasks")
//    var tasks:  ArrayList<Task>? = null
) {
    var has_checklist: Boolean? = false

    init {
//        if(tasks != null){
//            has_checklist = true
//        }
    }
}


