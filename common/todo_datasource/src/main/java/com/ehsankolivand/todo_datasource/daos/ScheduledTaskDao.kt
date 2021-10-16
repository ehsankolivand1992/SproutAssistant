package com.ehsankolivand.todo_datasource.daos

import androidx.room.*
import com.ehsankolivand.todo_datasource.entity.ScheduledTaskEntity
import kotlinx.coroutines.flow.Flow


@Dao
abstract class ScheduledTaskDao {

    @Query("SELECT * FROM ScheduledTaskEntity")
    abstract fun getAll(): Flow<List<ScheduledTaskEntity>>

    @Query("SELECT * FROM ScheduledTaskEntity WHERE is_done == 1")
    abstract fun getIsDone(): Flow<List<ScheduledTaskEntity>>


    @Query("SELECT * FROM ScheduledTaskEntity WHERE is_done == 0")
    abstract fun getToCome(): Flow<List<ScheduledTaskEntity>>


    @Query("SELECT * FROM ScheduledTaskEntity WHERE ID == :id")
    abstract fun searchById(id: Long): ScheduledTaskEntity


    @Insert
    abstract fun insert(entity: ScheduledTaskEntity): Long

    @Update
    abstract suspend fun update(entity: ScheduledTaskEntity)

    @Delete
    abstract suspend fun deleteEntity(entity: ScheduledTaskEntity): Int

}