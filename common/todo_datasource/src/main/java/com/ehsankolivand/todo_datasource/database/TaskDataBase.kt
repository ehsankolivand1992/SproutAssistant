package com.ehsankolivand.todo_datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ehsankolivand.todo_datasource.daos.TaskDao
import com.ehsankolivand.todo_datasource.entity.Pomodoro
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity


@Database(entities = [TaskDatabaseEntity::class,Pomodoro::class],
    version = 2,exportSchema = false)
abstract class TaskDataBase:RoomDatabase() {
    abstract fun getDao():TaskDao
}
