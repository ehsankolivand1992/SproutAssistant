package com.ehsankolivand.todo_datasource.repository


import com.ehsankolivand.datasource.daos_struc.BaseTodoRepository
import com.ehsankolivand.todo_datasource.daos.TaskDao
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

class TodoRepository @Inject constructor(private val dao: TaskDao) {

     fun getAll(): Flow<List<TaskDatabaseEntity>> {
        return dao.getAll()
    }


     fun search(entity: TaskDatabaseEntity): TaskDatabaseEntity {
        return dao.searchById(entity.id)
    }

    fun insertOrUpdate(entity: TaskDatabaseEntity) {
        dao.insert(entity)
    }



}
