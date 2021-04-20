package com.ehsankolivand.todo_datasource.Daos

import androidx.room.*
import com.ehsankolivand.datasource.daos_struc.BaseDao
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import kotlinx.coroutines.flow.Flow


@Dao
abstract class TaskDao:BaseDao<TaskDatabaseEntity> {

    @Query("SELECT * FROM TaskDatabaseEntity")
    abstract override fun getAll(): Flow<List<TaskDatabaseEntity>>

    @Query("SELECT * FROM TaskDatabaseEntity WHERE DND == 1")
    abstract override fun getIsDone(): Flow<List<TaskDatabaseEntity>>

    @Query("SELECT * FROM TaskDatabaseEntity WHERE DND == 0")
    abstract override fun getToCome(): Flow<List<TaskDatabaseEntity>>

    @Query("SELECT * FROM taskdatabaseentity WHERE ID == :id")
    abstract override fun searchById(id: Long): TaskDatabaseEntity

    @Insert
    abstract override suspend fun insert(entity: TaskDatabaseEntity): Long

    @Insert
    abstract override suspend fun insertAll(vararg entity: TaskDatabaseEntity)

    @Update
    abstract override suspend fun update(entity: TaskDatabaseEntity)

    @Delete
    abstract override suspend fun deleteEntity(entity: TaskDatabaseEntity): Int


    override suspend fun InsertOrupdate(entity: TaskDatabaseEntity) {
        if (entity.id!=0L)
        {
            this.insert(entity)
        }else {
            this.update(entity)
        }
    }
}