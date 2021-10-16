package com.ehsankolivand.todo_datasource.daos

import androidx.room.*
import com.ehsankolivand.todo_datasource.entity.GoalEntity
import com.ehsankolivand.todo_datasource.entity.ScheduledTaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class GoalDao {
    @Query("SELECT * FROM GoalEntity")
    abstract fun getGoals(): Flow<List<GoalEntity>>

    @Insert
    abstract fun insertGoal(goalEntity: GoalEntity)

    @Delete
    abstract fun deleteGoal(goalEntity: GoalEntity):Int

    @Update
    abstract fun updateGoal(goalEntity: GoalEntity)



    @Query("SELECT * FROM GoalEntity WHERE is_done == 1")
    abstract fun getIsDone(): Flow<List<GoalEntity>>

    @Query("SELECT * FROM GoalEntity WHERE is_done == 0")
    abstract fun getToCome(): Flow<List<GoalEntity>>

}