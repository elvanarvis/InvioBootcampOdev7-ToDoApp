package com.bootcamp.inviobootcampodev7_todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.bootcamp.inviobootcampodev7_todoapp.R
import com.bootcamp.inviobootcampodev7_todoapp.data.entity.ToDo
import com.bootcamp.inviobootcampodev7_todoapp.databinding.FragmentCreateToDoBinding
import com.bootcamp.inviobootcampodev7_todoapp.ui.viewmodel.CreateToDoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateToDoFragment : Fragment(R.layout.fragment_create_to_do) {

    private lateinit var binding: FragmentCreateToDoBinding
    private lateinit var viewModel: CreateToDoViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.toDoCreateFragment = this

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CreateToDoViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonSave(do_txt: String) {

        viewModel.save(do_txt)
    }
}
