package com.bootcamp.inviobootcampodev7_todoapp.ui.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.bootcamp.inviobootcampodev7_todoapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailToDoViewModel @Inject constructor(var trepo : ToDoRepository) : ViewModel() {

    fun update(do_id: Int, do_txt: String, view: View) {
        CoroutineScope(Dispatchers.Main).launch {

            trepo.update(do_id, do_txt, view)
        }
    }

}