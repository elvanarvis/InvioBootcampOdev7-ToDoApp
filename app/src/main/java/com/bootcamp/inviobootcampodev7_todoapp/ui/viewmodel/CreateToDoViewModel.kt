package com.bootcamp.inviobootcampodev7_todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.bootcamp.inviobootcampodev7_todoapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateToDoViewModel @Inject constructor(var trepo : ToDoRepository): ViewModel() {

    fun save( do_txt: String){
        CoroutineScope(Dispatchers.Main).launch {
            trepo.save(do_txt)
        }
    }
}