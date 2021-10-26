package com.ehsankolivand.uicenter.ui_connector_interfaces

import com.ehsankolivand.todo_datasource.entity.BaseTodoEntity

interface ConnectorAddGroupDialog {
    fun SaveGroupTask(baseTodoEntity: BaseTodoEntity)
    fun SaveGroupState(baseTodoEntity: BaseTodoEntity)
}
