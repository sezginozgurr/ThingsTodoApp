package com.example.thingstodoapp.util

import androidx.room.*
import com.example.thingstodoapp.model.ToModel


/**     Code with ❤
╔════════════════════════════╗
║  Created by Özgür Can  ║
╠════════════════════════════╣
║ sezginzgurr@gmail.com ║
╠════════════════════════════╣
║     20/08/2020 - 15:28     ║
╚════════════════════════════╝
 */
@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo_table")
    fun getAllNotes(): List<ToModel>

    @Insert
    fun insertAll(vararg todo: ToModel)

    @Delete
    fun deleteNote(todo: ToModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun save(todo: List<ToModel>)
}