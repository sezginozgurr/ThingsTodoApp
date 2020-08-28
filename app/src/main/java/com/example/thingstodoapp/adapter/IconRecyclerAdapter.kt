package com.example.thingstodoapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thingstodoapp.model.IconModel


/**     Code with ❤
╔════════════════════════════╗
║  Created by Özgür Can  ║
╠════════════════════════════╣
║ sezginzgurr@gmail.com ║
╠════════════════════════════╣
║     28/08/2020 - 11:05     ║
╚════════════════════════════╝
 */
class IconRecyclerAdapter(
    val iconList: List<IconModel>,
    private val onItemClickListener: (IconModel, position: Int) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return IconHolder(parent)
    }

    override fun getItemCount(): Int {
        return iconList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as IconHolder).bindTo(iconList[position], position, onItemClickListener)
    }

    fun updateItem(position: Int, iconModel: IconModel) {
        notifyItemChanged(position, iconModel)

    }

    fun getItems(): List<IconModel?> {
        return iconList
    }
}