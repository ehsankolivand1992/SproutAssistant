package com.ehsankolivand.todo_datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ehsankolivand.todo_datasource.daos.TaskDao
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity

@Database(entities = [TaskDatabaseEntity::class],version = 1,exportSchema = false)
abstract class TaskDataBase:RoomDatabase() {
    abstract fun getDao():TaskDao
    companion object{
        @Volatile
        private var INSTANCE:TaskDataBase?=null
        fun getInstance(context: Context):TaskDataBase
        {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    TaskDataBase::class.java,
                    "sproutdb"
                ).build()

                instance
            }
        }

    }
}