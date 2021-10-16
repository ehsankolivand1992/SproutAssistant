package com.ehsankolivand.todo_datasource.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
open class BaseTodoEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var id: Long = 0L

    @ColumnInfo(name= "title")
    var title:String

    @ColumnInfo(name= "description")
    var description:String

    @ColumnInfo(name="sticker")
    var sticker:String

    @ColumnInfo(name="parent_id")
    var parent_id: Long


    @field:ColumnInfo(name = "is_done")
    var isDone: Boolean


    @field:ColumnInfo(name = "task_type")
    var taskType:String

    @field:ColumnInfo(name = "color")
    var color:String



    constructor(
        id: Long,
        title: String,
        description: String,
        sticker: String,
        parent_id: Long,
        isDone: Boolean,
        taskType: String,
        color: String
    ) {
        this.id = id
        this.title = title
        this.description = description
        this.sticker = sticker
        this.parent_id = parent_id
        this.isDone = isDone
        this.taskType = taskType
        this.color = color
    }


}