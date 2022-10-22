package com.bootcamp.inviobootcampodev7_todoapp.room

import androidx.room.*
import com.bootcamp.inviobootcampodev7_todoapp.data.entity.ToDo

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo")
    suspend fun toDoLoading() : List<ToDo>

    @Insert
    suspend fun save(toDo: ToDo)

    @Update
    suspend fun update(toDo: ToDo)

    @Delete
    suspend fun delete(toDo: ToDo)

    @Query("SELECT * FROM todo WHERE do_txt like '%' || :word || '%'")
    suspend fun search(word: String) : List<ToDo>

    @Update
    suspend fun click(toDo: ToDo)
}