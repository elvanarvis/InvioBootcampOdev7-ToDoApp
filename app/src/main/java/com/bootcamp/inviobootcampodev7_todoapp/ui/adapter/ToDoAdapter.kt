package com.bootcamp.inviobootcampodev7_todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.inviobootcampodev7_todoapp.R
import com.bootcamp.inviobootcampodev7_todoapp.data.entity.ToDo
import com.bootcamp.inviobootcampodev7_todoapp.databinding.CardViewBinding
import com.bootcamp.inviobootcampodev7_todoapp.ui.fragment.MainFragment
import com.bootcamp.inviobootcampodev7_todoapp.ui.fragment.MainFragmentDirections
import com.bootcamp.inviobootcampodev7_todoapp.ui.viewmodel.MainViewModel
import com.bootcamp.inviobootcampodev7_todoapp.utils.changePage
import com.google.android.material.snackbar.Snackbar

class ToDoAdapter(var mContext: Context, var toDoList: List<ToDo>, var viewModel: MainViewModel) :
    RecyclerView.Adapter<ToDoAdapter.CardViewHolder>() {

    inner class CardViewHolder(binding: CardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: CardViewBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding: CardViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.card_view,
            parent,
            false
        )
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

        val toDo = toDoList.get(position)
        val t = holder.binding
        t.toDoObject = toDo

        t.textViewDo.text = toDo.do_txt
        t.cardView.setOnClickListener {
            val nav = MainFragmentDirections.actionMainFragmentToDetailToDoFragment(todo = toDo)
            Navigation.changePage(it, nav)
        }

        if(toDo.done == 1)
            t.checkBox.isChecked


        if (t.checkBox.isChecked) {
            t.cardView.setCardBackgroundColor(ContextCompat.getColor(mContext, R.color.orange))
        }


        t.checkBox.setOnCheckedChangeListener { compoundButton, b ->
            when (b) {
                true ->{
                    viewModel.click(toDo.do_id, toDo.do_txt,1)
                    Log.e("ToDo", "${toDo.done} - 1")
                    t.cardView.setCardBackgroundColor(ContextCompat.getColor(mContext, R.color.orange))
                }
                false ->{
                    viewModel.click(toDo.do_id,toDo.do_txt,0)
                    Log.e("ToDo", "${toDo.done} - 0")
                    t.cardView.setCardBackgroundColor(ContextCompat.getColor(mContext, R.color.white))
                }
            }
        }

        // t.cardView.setCardBackgroundColor(ContextCompat.getColor(mContext,R.color.white))

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.delete(toDo.do_id)
                }
                .show()

        }
    }

    override fun getItemCount() = toDoList.size


}