
package com.ehsankolivand.todo_datasource.entity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.ehsankolivand.constants.Constants
import java.util.*

@Entity
data class TaskDatabaseEntity(
    @field:ColumnInfo(name = "Name") val name: String?,

/** Work duration, in minutes.  */
    @field:ColumnInfo(name = "WorkDuration") val workDuration: Int,

/** Break duration, in minutes.  */
    @field:ColumnInfo(name = "BreakDuration") val breakDuration: Int,
    @field:ColumnInfo(name = "LongBreaks") val isLongBreaks: Boolean,

/** Long break duration, in minutes.  */
    @field:ColumnInfo(name = "LongBreakDuration") val longBreakDuration: Int,
    @field:ColumnInfo(name = "SessionsBeforeLongBreak") val sessionsBeforeLongBreak: Int,
    @field:ColumnInfo(
        name = "DND"
    ) val isDND: Boolean,
    @field:ColumnInfo(name = "KeepDNDOnBreaks") val isKeepDNDOnBreaks: Boolean,
    @field:ColumnInfo(name = "WiFi") val isWiFi: Boolean,
    @field:ColumnInfo(name = "is_done") val isDone: Boolean,
    @field:ColumnInfo(name = "showInStatistics") val isShowInStatistics: Boolean,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var id = 0L
    @Ignore
    constructor(name: String?) : this(
        name,
        Constants.DEFAULT_WORK_TIME,
        Constants.DEFAULT_BREAK_TIME,
        true,
        Constants.DEFAULT_LONG_BREAK_TIME,
        Constants.DEFAULT_SESSIONS_BEFORE_LONG_BREAK,
        false,
        false,
        false,
        false,
        true
    ) {
    }
}
