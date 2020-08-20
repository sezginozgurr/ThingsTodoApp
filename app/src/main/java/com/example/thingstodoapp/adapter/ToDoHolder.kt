package com.example.thingstodoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thingstodoapp.R
import com.example.thingstodoapp.model.ToModel


/**     Code with ❤
╔════════════════════════════╗
║  Created by Özgür Can  ║
╠════════════════════════════╣
║ sezginzgurr@gmail.com ║
╠════════════════════════════╣
║     20/08/2020 - 17:48     ║
╚════════════════════════════╝
 */
class ToDoHolder(container: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(container.context).inflate(R.layout.row_layout, container, false)
) {
    val todoTitle: TextView = itemView.findViewById(R.id.title)
    val todoDescription: TextView = itemView.findViewById(R.id.description)
    val startDate: TextView = itemView.findViewById(R.id.start_date)
    val endDate: TextView = itemView.findViewById(R.id.end_date)

    fun bind(todoModel: ToModel) {
        todoTitle.text = todoModel.todo
        todoDescription.text = todoModel.note
        startDate.text = todoModel.startDate
        endDate.text = todoModel.endDate
    }
}