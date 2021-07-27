package com.ehsankolivand.todo_datasource.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pomodoro(
  @PrimaryKey(autoGenerate = true)val id:Int,
  @ColumnInfo(name = "Date")
   val  Date:String,
  @ColumnInfo(name = "CompletedWorks")
  val CompletedWorks:Int,
  @ColumnInfo(name = "CompletedWorkTime")
  val  CompletedWorkTime:Long,
  @ColumnInfo(name = "IncompleteWorks")
  val IncompleteWorks:Int,
  @ColumnInfo(name = "IncompleteWorkTime")
  val IncompleteWorkTime:Long,
  @ColumnInfo(name = "Breaks")
  val Breaks:Int,
  @ColumnInfo(name = "BreakTime")
  val BreakTime:Long,
  @ColumnInfo(name = "TaskId")
  val taskID:Int
)
