package com.example.thingstodoapp.util

import com.example.thingstodoapp.R
import com.example.thingstodoapp.model.IconModel


/**     Code with ❤
╔════════════════════════════╗
║  Created by Özgür Can  ║
╠════════════════════════════╣
║ sezginzgurr@gmail.com ║
╠════════════════════════════╣
║     28/08/2020 - 11:20     ║
╚════════════════════════════╝
 */
object Mock {
    fun getMockData(): List<IconModel> {
        val iconModel0 = IconModel(R.drawable.meeting, "Toplanti")
        val iconModel1 = IconModel(R.drawable.book, "Kitap")
        val iconModel2 = IconModel(R.drawable.music, "Muzik")
        val iconModel3 = IconModel(R.drawable.note, "Not")
        val iconModel4 = IconModel(R.drawable.pill, "Ilac")
        val iconModel5 = IconModel(R.drawable.water, "Su icme")


        val iconList: ArrayList<IconModel> = ArrayList()
        iconList.add(iconModel0)
        iconList.add(iconModel1)
        iconList.add(iconModel2)
        iconList.add(iconModel3)
        iconList.add(iconModel4)
        iconList.add(iconModel5)

        return iconList
    }
}