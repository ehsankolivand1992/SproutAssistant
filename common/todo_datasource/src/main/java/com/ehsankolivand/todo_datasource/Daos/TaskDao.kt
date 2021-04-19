package com.ehsankolivand.todo_datasource.Daos

import com.ehsankolivand.datasource.BaseDao
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity

class TaskDao:BaseDao<TaskDatabaseEntity>() {
    override suspend fun insert(entity: TaskDatabaseEntity): Long {
        TODO("Not yet implemented")
    }

    override suspend fun insertAll(vararg entity: TaskDatabaseEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun insertAll(entities: List<TaskDatabaseEntity>) {
        TODO("Not yet implemented")
    }

    override suspend fun update(entity: TaskDatabaseEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteEntity(entity: TaskDatabaseEntity): Int {
        TODO("Not yet implemented")
    }

    override suspend fun InsertOrupdate(entity: TaskDatabaseEntity) {
        TODO("Not yet implemented")
    }
}