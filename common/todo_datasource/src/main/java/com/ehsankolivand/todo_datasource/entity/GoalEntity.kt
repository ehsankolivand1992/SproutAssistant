package com.ehsankolivand.todo_datasource.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
 class GoalEntity(id: Long, title: String, description: String, sticker: String,goal: String)
    :BaseTodoEntity(id, title, description, sticker, 0, false, "", "")
{
    @field:ColumnInfo(name = "goal")
    val goal:String = goal

}

