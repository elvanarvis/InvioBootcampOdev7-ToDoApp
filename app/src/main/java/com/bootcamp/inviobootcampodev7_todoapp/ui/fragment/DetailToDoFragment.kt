package com.bootcamp.inviobootcampodev7_todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bootcamp.inviobootcampodev7_todoapp.R
import com.bootcamp.inviobootcampodev7_todoapp.databinding.FragmentDetailToDoBinding


class DetailToDoFragment : Fragment(R.layout.fragment_detail_to_do) {

    private lateinit var binding: FragmentDetailToDoBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailToDoBinding.bind(view)

        val bundle: DetailToDoFragmentArgs by navArgs()
        val takeToDo = bundle.todo

        binding.etUpdate.setText(takeToDo.do_txt)

    }
}

