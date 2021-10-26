package com.ehsankolivand.todo_datasource.entity

import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
open class BaseTodoEntity() :Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var id: Long = 0L

    @ColumnInfo(name= "title")
     var title:String = ""

    @ColumnInfo(name= "description")
     var description:String=""

    @ColumnInfo(name="sticker")
     var sticker:Int=0


    @ColumnInfo(name="parent_id")
     var parent_id: Long=0


    @field:ColumnInfo(name = "is_done")
    var isDone: Boolean=false


    @field:ColumnInfo(name = "task_type")
    var taskType:String=""

    @field:ColumnInfo(name = "color")
    var color:Long=0

    constructor(parcel: Parcel) : this() {
        id = parcel.readLong()
        title = parcel.readString().toString()
        description = parcel.readString().toString()
        sticker = parcel.readInt()
        parent_id = parcel.readLong()
        isDone = parcel.readByte() != 0.toByte()
        taskType = parcel.readString().toString()
        color = parcel.readLong()
    }


    constructor(
        id: Long = 0,
        title: String="",
        description: String="",
        sticker: Int=0,
        parent_id: Long=0,
        isDone: Boolean=false,
        taskType: String="",
        color: Long= Color.WHITE.toLong()
    ) : this() {
        this.id = id
        this.title = title
        this.description = description
        this.sticker = sticker
        this.parent_id = parent_id
        this.isDone = isDone
        this.taskType = taskType
        this.color = color
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeInt(sticker)
        parcel.writeLong(parent_id)
        parcel.writeByte(if (isDone) 1 else 0)
        parcel.writeString(taskType)
        parcel.writeLong(color)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BaseTodoEntity> {
        override fun createFromParcel(parcel: Parcel): BaseTodoEntity {
            return BaseTodoEntity(parcel)
        }

        override fun newArray(size: Int): Array<BaseTodoEntity?> {
            return arrayOfNulls(size)
        }
    }


}