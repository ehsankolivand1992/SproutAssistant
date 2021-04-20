package com.ehsankolivand.todo_datasource.Daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ehsankolivand.datasource.daos_struc.BaseDao
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity


@Dao
abstract class TaskDao() {

    @Insert
    abstract   fun insert(entity: TaskDatabaseEntity): Long


    @Query("SELECT * FROM TaskDatabaseEntity")
    abstract fun getAllTasks():List<TaskDatabaseEntity>
/*

    abstract  suspend fun insertAll(vararg entity: TaskDatabaseEntity)

    abstract  suspend fun insertAll(entities: List<TaskDatabaseEntity>)

    abstract  suspend fun update(entity: TaskDatabaseEntity)

    abstract  suspend fun deleteEntity(entity: TaskDatabaseEntity): Int

    abstract  suspend fun InsertOrupdate(entity: TaskDatabaseEntity)*/
}