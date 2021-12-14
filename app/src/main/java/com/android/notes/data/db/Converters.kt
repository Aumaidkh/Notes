package com.android.notes.data.db

import androidx.room.TypeConverter
import com.android.notes.data.db.entities.TodoItem
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import com.google.gson.Gson




class Converters {

    @TypeConverter
    fun listToJsonString(value: List<TodoItem?>): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String) = Gson().fromJson(value, Array<TodoItem?>::class.java).toList()

}