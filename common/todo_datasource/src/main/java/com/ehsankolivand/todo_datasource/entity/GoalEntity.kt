package com.ehsankolivand.todo_datasource.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
 class GoalEntity(id: Long, title: String, description: String, sticker: Int,goal: String,color:Long)
    :BaseTodoEntity(id, title, description, sticker, 0, false, "", color)
{
    @field:ColumnInfo(name = "goal")
    val goal:String = goal

}

