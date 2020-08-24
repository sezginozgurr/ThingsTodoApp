package com.example.thingstodoapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thingstodoapp.model.ToModel


class TodoListAdapter(
    private val todoList: List<ToModel>,
    private val onItemClickListener: (ToModel) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ToDoHolder(parent)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ToDoHolder).bind(todoList[position], onItemClickListener)

    }
}