package com.bootcamp.inviobootcampodev7_todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bootcamp.inviobootcampodev7_todoapp.data.entity.ToDo
import com.bootcamp.inviobootcampodev7_todoapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var trepo : ToDoRepository) : ViewModel() {

    var toDoList = MutableLiveData<List<ToDo>>()

    init {
        toDoLoading()
    }

    fun toDoLoading(){
        CoroutineScope(Dispatchers.Main).launch {

           toDoList.value = trepo.toDoLoading()
        }
    }

    fun search(word: String){
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value = trepo.search(word)
        }
    }

    fun delete(do_id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            trepo.delete(do_id)
            toDoLoading()
        }
    }

    fun click(do_id: Int,do_txt: String , done: Int){
        CoroutineScope(Dispatchers.Main).launch {
            trepo.click(do_id,do_txt, done)
            Log.e("ToDo", "View modelde $done")
        }
    }
}