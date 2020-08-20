package com.example.thingstodoapp.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.thingstodoapp.model.ToModel
import com.example.thingstodoapp.util.ToDoDao


/**     Code with ❤
╔════════════════════════════╗
║  Created by Özgür Can  ║
╠════════════════════════════╣
║ sezginzgurr@gmail.com ║
╠════════════════════════════╣
║     20/08/2020 - 15:27     ║
╚════════════════════════════╝
 */
@Database(entities = [ToModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): ToDoDao

}