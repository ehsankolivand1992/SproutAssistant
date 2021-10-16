package com.ehsankolivand.sproutassistant.abstraction

import androidx.room.Delete
import com.ehsankolivand.todo_datasource.entity.GoalEntity
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity

interface IAppViewModel<T> {
    fun insert(entity: T)
    fun update(entity: T)
    fun delete(entity: T)

    suspend fun getAll()
}