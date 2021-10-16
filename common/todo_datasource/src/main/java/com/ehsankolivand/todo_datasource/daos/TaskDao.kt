package com.ehsankolivand.todo_datasource.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ehsankolivand.todo_datasource.entity.LableElement
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import kotlinx.coroutines.flow.Flow


@Dao
abstract class TaskDao {

    @Insert
    abstract fun insertTaskDatabaseEntity(TaskDatabaseEntity: TaskDatabaseEntity)

    @Query("SELECT ID FROM TaskDatabaseEntity WHERE showInStatistics = 1")
    abstract fun getIdsToShow(): IntArray


    //Set<Int> : A generic unordered collection of elements that does not support duplicate elements.
    @Query("UPDATE TaskDatabaseEntity SET showInStatistics = CASE WHEN ID IN(:TaskDatabaseEntityIds) THEN 1 ELSE 0 END")
    abstract fun updateShowInStatistics(TaskDatabaseEntityIds: Set<Int>)


    @Query("SELECT showInStatistics FROM TaskDatabaseEntity")
    abstract fun showInStatisticsAll(): Flow<List<Boolean>>


    @Query("SELECT ID, Name FROM TaskDatabaseEntity")
    abstract fun getAllTaskDatabaseEntityNames(): Flow<List<LableElement>>


    @Query("SELECT * FROM TaskDatabaseEntity")
    abstract fun getAll():  Flow<List<TaskDatabaseEntity>>


    @Query("SELECT 1 FROM TaskDatabaseEntity WHERE Name = :name")
    abstract fun isNameOccupied(name: String): Flow<Boolean>

    @Query("SELECT ID FROM TaskDatabaseEntity LIMIT 1")
    abstract fun getFirstTaskID(): Flow<Int>

    @Query("SELECT COUNT(*) FROM TaskDatabaseEntity")
    abstract fun getNumberOfTasks(): Flow<Int>


    @Query("DELETE FROM TaskDatabaseEntity WHERE id = :id")
    abstract fun deleteTask(id: Int)


    @Query("UPDATE TaskDatabaseEntity SET Name = :name WHERE id = :id")
    abstract fun updateTaskName(id: Int, name: String)

    @Query("SELECT * FROM TaskDatabaseEntity WHERE id = :id")
    abstract fun getTask(id: Int): Flow<TaskDatabaseEntity>

    @Query("UPDATE TaskDatabaseEntity SET WorkDuration = :duration WHERE id = :id")
    abstract fun updateWorkDuration(id: Int, duration: Int)


    @Query("UPDATE TaskDatabaseEntity SET BreakDuration = :duration WHERE id = :id")
    abstract fun updateBreakDuration(id: Int, duration: Int)


    @Query("UPDATE TaskDatabaseEntity SET LongBreakDuration = :duration WHERE id = :id")
    abstract fun updateLongBreakDuration(id: Int, duration: Int)

    @Query("UPDATE TaskDatabaseEntity SET SessionsBeforeLongBreak = :sessions WHERE id = :id")
    abstract fun updateSessionsBeforeLongBreak(id: Int, sessions: Int)

    @Query("SELECT WorkDuration FROM TaskDatabaseEntity WHERE id = :id")
    abstract fun getWorkDuration(id: Int): Int

    @Query("SELECT BreakDuration FROM TaskDatabaseEntity WHERE id = :id")
    abstract fun getBreakDuration(id: Int): Int

    @Query("SELECT LongBreakDuration FROM TaskDatabaseEntity WHERE id = :id")
    abstract fun getLongBreakDuration(id: Int): Int

    @Query("SELECT SessionsBeforeLongBreak FROM TaskDatabaseEntity WHERE id = :id")
    abstract fun getSessionsBeforeLongBreak(id: Int): Int

    @Query("UPDATE TaskDatabaseEntity SET LongBreaks = :areEnabled WHERE id = :id")
    abstract fun setLongBreaksEnabled(id: Int, areEnabled: Boolean)

    @Query("SELECT LongBreaks FROM TaskDatabaseEntity WHERE id = :id")
    abstract fun areLongBreaksEnabled(id: Int): Flow<Boolean>

    @Query("UPDATE TaskDatabaseEntity SET DND = :isEnabled WHERE id = :id")
    abstract fun setDNDEnabled(id: Int, isEnabled: Boolean)

    @Query("SELECT DND FROM TaskDatabaseEntity WHERE id = :id")
    abstract fun isDNDEnabled(id: Int): Flow<Boolean>

    @Query("UPDATE TaskDatabaseEntity SET KeepDNDOnBreaks = :isEnabled WHERE id = :id")
    abstract fun setKeepDNDOnBreaks(id: Int, isEnabled: Boolean)

    @Query("SELECT KeepDNDOnBreaks FROM TaskDatabaseEntity WHERE id = :id")
    abstract fun isDNDKeptOnBreaks(id: Int): Flow<Boolean>

    @Query("UPDATE TaskDatabaseEntity SET WiFi = :isEnabled WHERE id = :id")
    abstract fun setDisableWifi(id: Int, isEnabled: Boolean)

    @Query("SELECT WiFi FROM TaskDatabaseEntity WHERE id = :id")
    abstract fun isWifiDisabledDuringWorkSession(id: Int): Flow<Boolean>

    @Query("SELECT Name FROM TaskDatabaseEntity WHERE id = :id")
    abstract fun getName(id: Int): Flow<String>

}
