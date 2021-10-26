package com.ehsankolivand.uicenter.ui_connector_interfaces

import com.ehsankolivand.todo_datasource.entity.BaseTodoEntity

interface ConnectorFolderList {
    fun closeSideMenu()
    fun selectedFolder(folderSelected: BaseTodoEntity)
}