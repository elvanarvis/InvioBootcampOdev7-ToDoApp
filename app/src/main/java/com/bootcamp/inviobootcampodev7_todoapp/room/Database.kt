package com.bootcamp.inviobootcampodev7_todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bootcamp.inviobootcampodev7_todoapp.data.entity.ToDo

@Database(entities = [ToDo::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getToDoDao(): ToDoDao
}