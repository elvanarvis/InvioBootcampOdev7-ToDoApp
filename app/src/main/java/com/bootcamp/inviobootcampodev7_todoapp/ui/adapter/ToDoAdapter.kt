package com.bootcamp.inviobootcampodev7_todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.inviobootcampodev7_todoapp.R
import com.bootcamp.inviobootcampodev7_todoapp.data.entity.ToDo
import com.bootcamp.inviobootcampodev7_todoapp.databinding.CardViewBinding
import com.bootcamp.inviobootcampodev7_todoapp.ui.fragment.MainFragment
import com.bootcamp.inviobootcampodev7_todoapp.ui.fragment.MainFragmentDirections

class ToDoAdapter(var mContext: Context, var toDoList: List<ToDo>): RecyclerView.Adapter<ToDoAdapter.CardViewHolder>() {

    inner class CardViewHolder(binding: CardViewBinding) :
            RecyclerView.ViewHolder(binding.root) {
                var binding: CardViewBinding

                init {
                    this.binding = binding
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardViewBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

        val toDo = toDoList.get(position)
        val t = holder.binding

        t.tvDo.text = toDo.do_txt
        t.cardView.setOnClickListener {
            val nav = MainFragmentDirections.actionMainFragmentToDetailToDoFragment(todo = toDo)
            Navigation.findNavController(it).navigate(nav)
        }
        t.checkBox.isChecked.let {
        }
        t.ivDelete.setOnClickListener {
            delete()
        }
    }

    override fun getItemCount() = toDoList.size


    fun delete(){
        Log.e("ToDo", "silindi")
    }
}