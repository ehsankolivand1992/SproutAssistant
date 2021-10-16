package com.ehsankolivand.todo_datasource.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
class ScheduledTaskEntity(
    id: Long,
    title: String,
    description: String,
    sticker: String,
    parent_id: Long,
    @ColumnInfo(name = "time")
    var time: Long,
    @ColumnInfo(name = "date")
    var date: Long
) : BaseTodoEntity(id, title, description, sticker, parent_id, false, "", "")