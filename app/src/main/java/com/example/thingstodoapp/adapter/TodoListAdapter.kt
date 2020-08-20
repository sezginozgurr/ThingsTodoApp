package com.example.thingstodoapp.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thingstodoapp.model.ToModel


class TodoListAdapter(private val todoList: List<ToModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("title", todoList[0].todo)
        Log.d("endDate", todoList[1].endDate)
        Log.d("Desc", todoList[2].note)
        return ToDoHolder(parent)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ToDoHolder).bind(todoList[position])
    }
}