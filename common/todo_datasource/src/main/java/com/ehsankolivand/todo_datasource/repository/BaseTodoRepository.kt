package com.ehsankolivand.todo_datasource.repository

import com.ehsankolivand.todo_datasource.daos.BaseTodoDao
import com.ehsankolivand.todo_datasource.entity.BaseTodoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BaseTodoRepository @Inject constructor(private val BaseTodoDao: BaseTodoDao) {

    fun getAllBaseTodo(): Flow<List<BaseTodoEntity>>
    {
        return BaseTodoDao.getBaseTodo()
    }

    fun deleteBaseTodo(BaseTodoEntity: BaseTodoEntity)
    {
        BaseTodoDao.deleteBaseTodo(BaseTodoEntity)
    }

    fun updateBaseTodo(BaseTodoEntity: BaseTodoEntity)
    {
        BaseTodoDao.updateBaseTodo(BaseTodoEntity)
    }

    fun insertBaseTodo(BaseTodoEntity: BaseTodoEntity)
    {
        BaseTodoDao.insertBaseTodo(BaseTodoEntity)
    }


}