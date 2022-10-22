package com.bootcamp.inviobootcampodev7_todoapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bootcamp.inviobootcampodev7_todoapp.data.datasource.ToDoDataSource
import com.bootcamp.inviobootcampodev7_todoapp.data.repo.ToDoRepository
import com.bootcamp.inviobootcampodev7_todoapp.room.Database
import com.bootcamp.inviobootcampodev7_todoapp.room.ToDoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideToDoRepository(tds: ToDoDataSource): ToDoRepository {
        return ToDoRepository(tds)
    }

    @Provides
    @Singleton
    fun provideToDoDataSource(tdao: ToDoDao): ToDoDataSource {
        return ToDoDataSource(tdao)
    }

    @Provides
    @Singleton
    fun provideToDoDao(@ApplicationContext context: Context): ToDoDao {
        val db = Room.databaseBuilder(context, Database::class.java, "rehb.sqlite")
            .createFromAsset("rehb.sqlite").build()
        return db.getToDoDao()
    }
}