package com.ehsankolivand.todo_datasource.repository

import com.ehsankolivand.datasource.daos_struc.BaseTodoRepository
import com.ehsankolivand.todo_datasource.daos.TaskDao
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import kotlinx.coroutines.flow.Flow


class TodoRepository constructor(private val dao: TaskDao)
    :BaseTodoRepository<TaskDatabaseEntity> {


    override fun getAll(): Flow<List<TaskDatabaseEntity>> {
        return dao.getAll()
    }

    override fun search(entity: TaskDatabaseEntity): TaskDatabaseEntity {
        return dao.searchById(entity.id)
    }
    override suspend fun insertOrUpdate(entity: TaskDatabaseEntity) {
        dao.insert(entity)
    }

}