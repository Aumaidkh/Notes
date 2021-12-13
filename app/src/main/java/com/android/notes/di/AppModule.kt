package com.android.notes.di

import android.content.Context
import androidx.room.Room
import com.android.notes.data.db.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideNotesDao(db: NotesDatabase) = db.getNotesDao()


    @Singleton
    @Provides
    fun provideNotesDatabase(@ApplicationContext context: Context) : NotesDatabase {
        return Room.databaseBuilder(
            context,
            NotesDatabase::class.java,
            "NotesDB.db"
        ).build()
    }

}