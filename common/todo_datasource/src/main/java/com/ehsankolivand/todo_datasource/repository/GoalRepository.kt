package com.ehsankolivand.todo_datasource.repository

import com.ehsankolivand.todo_datasource.daos.GoalDao
import com.ehsankolivand.todo_datasource.entity.GoalEntity
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GoalRepository @Inject constructor(private val goalDao: GoalDao) {

    fun getAllGoal():Flow<List<GoalEntity>>
    {
        return goalDao.getGoals()
    }

    fun deleteGoal(goalEntity: GoalEntity)
    {
        goalDao.deleteGoal(goalEntity)
    }

    fun updateGoal(goalEntity: GoalEntity)
    {
        goalDao.updateGoal(goalEntity)
    }

    fun insertGoal(goalEntity: GoalEntity)
    {
        goalDao.insertGoal(goalEntity)
    }


}