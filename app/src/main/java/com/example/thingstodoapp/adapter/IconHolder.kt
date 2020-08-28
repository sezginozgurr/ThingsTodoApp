package com.example.thingstodoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.thingstodoapp.R
import com.example.thingstodoapp.model.IconModel


/**     Code with ❤
╔════════════════════════════╗
║  Created by Özgür Can  ║
╠════════════════════════════╣
║ sezginzgurr@gmail.com ║
╠════════════════════════════╣
║     28/08/2020 - 11:06     ║
╚════════════════════════════╝
 */
class IconHolder(container: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(container.context).inflate(
        R.layout.icon_list_item, container, false
    )
) {

    val iconImage = itemView.findViewById(R.id.chose_img) as ImageView
    val iconTitle = itemView.findViewById(R.id.choseTitle) as TextView
    val card1 = itemView.findViewById(R.id.card1) as CardView

    fun bindTo(
        iconModel: IconModel,
        position: Int,
        onItemClickListener: (IconModel, position: Int) -> Unit
    ) {
        iconImage.setImageResource(iconModel.iconImg)
        iconTitle.text = iconModel.iconTitle
        itemView.setOnClickListener {
            onItemClickListener(iconModel, position)
        }

        if (iconModel.isChecked) {
            card1.setCardBackgroundColor(
                ContextCompat.getColor(
                    card1.context,
                    R.color.color_gray
                )
            )
        } else {
            card1.setCardBackgroundColor(
                ContextCompat.getColor(
                    card1.context,
                    R.color.white_color
                )
            )
        }
    }
}