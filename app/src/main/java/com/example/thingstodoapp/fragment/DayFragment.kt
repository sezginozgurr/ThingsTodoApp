@file:Suppress("DEPRECATION")

package com.example.thingstodoapp.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.brkcnszgn.dateandtimepickerdialog.ClickListener
import com.example.thingstodoapp.DB.AppDatabase
import com.example.thingstodoapp.R
import com.example.thingstodoapp.adapter.TodoListAdapter
import com.example.thingstodoapp.model.ToModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.*


class DayFragment : Fragment(R.layout.fragment_home_page) {


    private var detailFragment: DetailFragment? = null
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<*>

    private val bottomSheetCallback = object :
        BottomSheetBehavior.BottomSheetCallback() {
        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            TODO("Not yet implemented")
        }

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            when (newState) {
                BottomSheetBehavior.STATE_EXPANDED -> {
                    fab_btn.visibility = View.GONE
                }
                BottomSheetBehavior.STATE_COLLAPSED -> {
                    fab_btn.visibility = View.VISIBLE
                }
                else -> fab_btn.visibility = View.VISIBLE
            }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailFragment = DetailFragment()
        val todoList: List<ToModel>
        val db: AppDatabase =
            Room.databaseBuilder(view.context, AppDatabase::class.java, "notes")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        todoList = db.todoDao().getAllNotes()
        recycler_todo.adapter = TodoListAdapter(todoList) {
            alertDialog(it)

            //navController?.navigate(R.id.action_homePageFragment_to_detailFragment)
        }
        (recycler_todo.adapter as TodoListAdapter).notifyDataSetChanged() // degisiklikden sonra ki hali
        spinnersound.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
            }

        }
        val bottomSheetBehavior = BottomSheetBehavior.from(layoutBottomSheet)
        fab_btn.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
            layoutBottomSheet.visibility = View.VISIBLE
        }
        datetime_start.setOnClickListener(ClickListener {})
        datetime_end.setOnClickListener(ClickListener {})
        btn_save.setOnClickListener {
            val list = todoList as MutableList
            val note: ToModel = ToModel(
                todo_title.text.toString(),
                todo_note.text.toString(),
                datetime_start.text.toString(),
                datetime_end.text.toString(), "zil1"
            )
            db.todoDao().insertAll(note)
            list.add(note)
            recycler_todo.adapter = TodoListAdapter(list) {

            }
            layoutBottomSheet.visibility = View.INVISIBLE
            (recycler_todo.adapter as TodoListAdapter).notifyDataSetChanged()

        }

    }

    fun alertDialog(toModel: ToModel): AlertDialog.Builder {
        val dialog = AlertDialog.Builder(view?.context)
        val dialogView = layoutInflater.inflate(R.layout.fragment_detail, null)
        val detailDay = dialogView.findViewById(R.id.detailDay) as TextView
        detailDay.text = toModel.startDate
        val detailTitle = dialogView.findViewById(R.id.detailTitle) as TextView
        detailTitle.text = toModel.todo
        val detailDescription = dialogView.findViewById(R.id.detailDescription) as TextView
        detailDescription.text = toModel.note
        dialog.setView(dialogView)
        dialog.setCancelable(false)
        dialog.setPositiveButton("Kapat") { dialog, _ ->
            dialog.dismiss()
        }
        dialog.show()
        return dialog
    }


}

