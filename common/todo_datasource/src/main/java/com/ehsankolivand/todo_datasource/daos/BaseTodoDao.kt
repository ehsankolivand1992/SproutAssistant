package com.ehsankolivand.todo_datasource.daos

import androidx.room.*
import com.ehsankolivand.todo_datasource.entity.BaseTodoEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class BaseTodoDao {

   
        @Query("SELECT * FROM BaseTodoEntity")
        abstract fun getBaseTodo(): Flow<List<BaseTodoEntity>>

        @Insert
        abstract fun insertBaseTodo(BaseTodoEntity: BaseTodoEntity)

        @Delete
        abstract fun deleteBaseTodo(BaseTodoEntity: BaseTodoEntity):Int

        @Update
        abstract fun updateBaseTodo(BaseTodoEntity: BaseTodoEntity)



        @Query("SELECT * FROM BaseTodoEntity WHERE is_done == 1")
        abstract fun getIsDone(): Flow<List<BaseTodoEntity>>

        @Query("SELECT * FROM BaseTodoEntity WHERE is_done == 0")
        abstract fun getToCome(): Flow<List<BaseTodoEntity>>

    
}