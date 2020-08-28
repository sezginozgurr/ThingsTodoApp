package com.example.thingstodoapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "todo_table")
data class ToModel(
    @ColumnInfo(name = "todo")
    var todo: String,
    @ColumnInfo(name = "note")
    var note: String,
    @ColumnInfo(name = "startDate")
    var startDate: String,
    @ColumnInfo(name = "EndDate")
    var endDate: String,
    @ColumnInfo(name = "sound")
    var sound: String,
    @ColumnInfo(name = "resim")
    var resim: Int
) {


    @PrimaryKey(autoGenerate = true)
    var toDoId: Int = 0
}