package com.bootcamp.inviobootcampodev7_todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.inviobootcampodev7_todoapp.R
import com.bootcamp.inviobootcampodev7_todoapp.data.entity.ToDo
import com.bootcamp.inviobootcampodev7_todoapp.databinding.FragmentMainBinding
import com.bootcamp.inviobootcampodev7_todoapp.ui.adapter.ToDoAdapter


class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.fab.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_createToDoFragment)
        }

        val toDoList = ArrayList<ToDo>()

        val t1 = ToDo(1, "Evi süpür")
        val t2 = ToDo(2, "Ödevini bitir")
        val t3 = ToDo(3, "Şarkı listeni düzenle")
        val t4 = ToDo(4, "Defter al")
        val t5 = ToDo(5,"Kargo gelecek")
        val t6 = ToDo(6,"Mayonez al")

        toDoList.add(t1)
        toDoList.add(t2)
        toDoList.add(t3)
        toDoList.add(t4)
        toDoList.add(t5)
        toDoList.add(t6)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        val adapter = ToDoAdapter(requireContext(),toDoList)
        binding.rv.adapter = adapter
    }
}

