package com.ehsankolivand.sproutassistant.abstraction

import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity

interface IAppViewModel {
    fun insert(taskDatabaseEntity: TaskDatabaseEntity)
}