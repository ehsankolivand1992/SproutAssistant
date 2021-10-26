package com.ehsankolivand.todo_datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ehsankolivand.todo_datasource.daos.BaseTodoDao
import com.ehsankolivand.todo_datasource.daos.GoalDao
import com.ehsankolivand.todo_datasource.daos.ScheduledTaskDao
import com.ehsankolivand.todo_datasource.daos.TaskDao
import com.ehsankolivand.todo_datasource.entity.BaseTodoEntity
import com.ehsankolivand.todo_datasource.entity.GoalEntity
import com.ehsankolivand.todo_datasource.entity.ScheduledTaskEntity
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity


@Database(entities = [TaskDatabaseEntity::class,GoalEntity::class,ScheduledTaskEntity::class,BaseTodoEntity::class],
    version = 1,exportSchema = false)
abstract class TaskDataBase:RoomDatabase() {

    abstract fun getDao():TaskDao
    abstract fun getScheduledTaskDaop():ScheduledTaskDao
    abstract fun getGoalDao():GoalDao
    abstract fun getBaseTodoDao():BaseTodoDao
}
