package com.ehsankolivand.todo_datasource.daos

import androidx.room.*
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import kotlinx.coroutines.flow.Flow


@Dao
abstract class TaskDao {


    @Query("SELECT * FROM TaskDatabaseEntity")
    abstract fun getAll(): Flow<List<TaskDatabaseEntity>>


    @Query("SELECT * FROM TaskDatabaseEntity WHERE DND == 1")
    abstract fun getIsDone(): Flow<List<TaskDatabaseEntity>>


    @Query("SELECT * FROM TaskDatabaseEntity WHERE DND == 0")
    abstract fun getToCome(): Flow<List<TaskDatabaseEntity>>


    @Query("SELECT * FROM TaskDatabaseEntity WHERE ID == :id")
    abstract fun searchById(id: Long): TaskDatabaseEntity


    @Insert
    abstract fun insert(entity: TaskDatabaseEntity): Long

    @Update
    abstract suspend fun update(entity: TaskDatabaseEntity)

    @Delete
    abstract suspend fun deleteEntity(entity: TaskDatabaseEntity): Int



}