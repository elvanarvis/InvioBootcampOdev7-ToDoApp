package com.bootcamp.inviobootcampodev7_todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.inviobootcampodev7_todoapp.R
import com.bootcamp.inviobootcampodev7_todoapp.data.entity.ToDo
import com.bootcamp.inviobootcampodev7_todoapp.databinding.FragmentMainBinding
import com.bootcamp.inviobootcampodev7_todoapp.ui.adapter.ToDoAdapter
import com.bootcamp.inviobootcampodev7_todoapp.ui.viewmodel.MainViewModel
import com.bootcamp.inviobootcampodev7_todoapp.utils.changePage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.toDoMainFragment = this
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        viewModel.toDoList.observe(viewLifecycleOwner) {
            val adapter = ToDoAdapter(requireContext(), it, viewModel)
            binding.toDoAdapter = adapter
        }

        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@MainFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                /* when (menuItem.itemId) {
                     R.id.action_search -> {
                         Toast.makeText(requireContext(), "Helal len", Toast.LENGTH_SHORT).show()
                         return true
                     }
                     else -> return false
                 }*/
                return false
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel: MainViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabClick(view: View) {

        Navigation.changePage(view, R.id.action_mainFragment_to_createToDoFragment)
        val v = "true"
        var f = false
        f = v.toBoolean()
        Log.e("ToDo", "$f")
        Log.e("ToDo" ,"${f.toString()}")

    }

    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        return true
    }

    fun search(word: String) {
        viewModel.search(word)
    }

    override fun onResume() {
        super.onResume()
        viewModel.toDoLoading()
    }
}

