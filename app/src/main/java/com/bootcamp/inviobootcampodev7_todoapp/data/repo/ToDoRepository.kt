package com.bootcamp.inviobootcampodev7_todoapp.data.repo

import android.util.Log
import com.bootcamp.inviobootcampodev7_todoapp.data.datasource.ToDoDataSource
import com.bootcamp.inviobootcampodev7_todoapp.data.entity.ToDo

class ToDoRepository(var tds: ToDoDataSource) {

    suspend fun save(do_txt: String) = tds.save(do_txt)

    suspend fun update(do_id: Int, do_txt:String) = tds.update(do_id,do_txt)

    suspend fun toDoLoading() : List<ToDo> = tds.toDoLoading()

    suspend fun search(word: String) : List<ToDo> = tds.search(word)

    suspend fun delete(do_id: Int) = tds.delete(do_id)

    suspend fun click(do_id: Int,do_txt: String ,done: Int) = tds.click(do_id,do_txt,done)
}