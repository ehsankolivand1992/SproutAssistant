package com.ehsankolivand.todo_datasource.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
class ScheduledTaskEntity(
    id: Long,
    title: String,
    description: String,
    sticker: Int,
    parent_id: Long,
    color:Long,
    @ColumnInfo(name = "time")
    var time: Long,
    @ColumnInfo(name = "date")
    var date: Long
) : BaseTodoEntity(id, title, description, sticker, parent_id, false, "", color)