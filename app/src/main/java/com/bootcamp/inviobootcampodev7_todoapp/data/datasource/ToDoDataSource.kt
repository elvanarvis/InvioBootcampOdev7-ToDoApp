package com.bootcamp.inviobootcampodev7_todoapp.data.datasource

import android.util.Log
import android.view.View
import androidx.navigation.Navigation
import com.bootcamp.inviobootcampodev7_todoapp.R
import com.bootcamp.inviobootcampodev7_todoapp.data.entity.ToDo
import com.bootcamp.inviobootcampodev7_todoapp.room.ToDoDao
import com.bootcamp.inviobootcampodev7_todoapp.utils.changePage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var tdao: ToDoDao){


    suspend fun save(do_txt: String,view: View) {
        if (do_txt.isNotEmpty()){
            val newDo = ToDo(0, do_txt, 0)
            tdao.save(newDo)
            Navigation.changePage(view, R.id.action_createToDoFragment_to_mainFragment)
        }
    }

    suspend fun update(do_id: Int, do_txt:String,view: View){
        val updateDo = ToDo(do_id, do_txt, 0)
        tdao.update(updateDo)
        Navigation.changePage(view, R.id.action_detailToDoFragment_to_mainFragment)
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