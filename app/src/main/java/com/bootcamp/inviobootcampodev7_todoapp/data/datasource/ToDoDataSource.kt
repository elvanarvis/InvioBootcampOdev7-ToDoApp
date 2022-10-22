package com.bootcamp.inviobootcampodev7_todoapp.data.datasource

import android.util.Log
import com.bootcamp.inviobootcampodev7_todoapp.data.entity.ToDo
import com.bootcamp.inviobootcampodev7_todoapp.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var tdao: ToDoDao){


    suspend fun save(do_txt: String) {
        val newDo = ToDo(0, do_txt, 0)
        tdao.save(newDo)
    }

    suspend fun update(do_id: Int, do_txt:String){
        val updateDo = ToDo(do_id, do_txt, 0)
        tdao.update(updateDo)
    }

    suspend fun toDoLoading() : List<ToDo> = withContext(Dispatchers.IO){
        tdao.toDoLoading()
    }

    suspend fun search(word: String) : List<ToDo> = withContext(Dispatchers.IO){
        tdao.search(word)
    }

    suspend fun delete(do_id: Int) {
        val deleteDo = ToDo(do_id, "", 0)
        tdao.delete(deleteDo)
    }

    suspend fun click(do_id: Int, do_txt: String ,done: Int){
        val clickDo = ToDo(do_id,do_txt,done)
        tdao.click(clickDo)
    }
}