package com.example.thingstodoapp.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thingstodoapp.R
import com.example.thingstodoapp.model.ToModel
import kotlin.random.Random


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
    private val cardView: LinearLayout = itemView.findViewById(R.id.cardView)
    private val todoTitle: TextView = itemView.findViewById(R.id.tv_title)
    val todoDescription: TextView = itemView.findViewById(R.id.description)
    val day: TextView = itemView.findViewById(R.id.day)

    //val mountNumber: TextView = itemView.findViewById(R.id.mountNumber)
    val hour: TextView = itemView.findViewById(R.id.hour)

    fun bind(todoModel: ToModel, onItemClickListener: (ToModel) -> Unit) {
        todoTitle.text = todoModel.todo
        todoDescription.text = todoModel.note
        val step = getDateStep(todoModel)
        day.text = step[0]
        hour.text = step[1]
        cardView.setBackgroundColor(randomBackGround())
        itemView.setOnClickListener {
            onItemClickListener(todoModel)
//            val intent = Intent(it.context, DetailFragment::class.java)
//
////            intent.putExtra("todo", todoModel.todo)
////            intent.putExtra("note", todoModel.note)
////            intent.putExtra("startDate", todoModel.startDate)
////            intent.putExtra("sound", todoModel.sound)
//
//            it.context.startActivity(intent)
//            onItemClick( todoModel) // sikinti cikarsa burda
        }

    }

    fun getDateStep(todoModel: ToModel): List<String> {
        val getDate = todoModel.startDate
        val splitGetDate = " "

        val resultDate = getDate.split(splitGetDate).toTypedArray()
        Log.e("tag", resultDate[0])
        val dateSplit = resultDate[0]

        val lastSplit = "."
        val resultDay = dateSplit.split(lastSplit).toTypedArray()
        Log.e("tag", "${resultDay[0]}   }")
        resultDate[0] = resultDay[0]

        return resultDate.toList()
    }

    fun randomBackGround(): Int {
        val randombg = Random.nextInt(255)

        return Color.argb(255, randombg, randombg, 255)

    }
}