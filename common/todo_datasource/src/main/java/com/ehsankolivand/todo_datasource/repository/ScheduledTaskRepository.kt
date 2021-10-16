package com.ehsankolivand.todo_datasource.repository

import com.ehsankolivand.todo_datasource.daos.ScheduledTaskDao
import com.ehsankolivand.todo_datasource.entity.ScheduledTaskEntity
import kotlinx.coroutines.flow.Flow

class ScheduledTaskRepository constructor(private val scheduledTaskDao: ScheduledTaskDao){


    fun getAllGoal():Flow<List<ScheduledTaskEntity>>
    {
        return scheduledTaskDao.getAll()
    }

    suspend fun deleteGoal(scheduledEntity: ScheduledTaskEntity)
    {
        scheduledTaskDao.deleteEntity(scheduledEntity)
    }

    suspend fun updateGoal(scheduledEntity: ScheduledTaskEntity)
    {
        scheduledTaskDao.update(scheduledEntity)
    }

    fun insertGoal(scheduledEntity: ScheduledTaskEntity)
    {
        scheduledTaskDao.insert(scheduledEntity)
    }
}