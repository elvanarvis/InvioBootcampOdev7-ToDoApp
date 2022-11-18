package com.bootcamp.inviobootcampodev7_todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bootcamp.inviobootcampodev7_todoapp.R
import com.bootcamp.inviobootcampodev7_todoapp.databinding.FragmentDetailToDoBinding
import com.bootcamp.inviobootcampodev7_todoapp.ui.viewmodel.DetailToDoViewModel
import com.bootcamp.inviobootcampodev7_todoapp.utils.changePage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailToDoFragment : Fragment(R.layout.fragment_detail_to_do) {

    private lateinit var binding: FragmentDetailToDoBinding
    private lateinit var viewModel: DetailToDoViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.toDoDetailFragment = this

        val bundle: DetailToDoFragmentArgs by navArgs()
        val takeToDo = bundle.todo
        binding.toDoObject = takeToDo
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel: DetailToDoViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonUpdate(do_id: Int, do_txt:String, view: View){
        viewModel.update(do_id,do_txt,view)
    }
}

