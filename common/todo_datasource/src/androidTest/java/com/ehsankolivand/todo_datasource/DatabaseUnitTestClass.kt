package com.ehsankolivand.todo_datasource

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ehsankolivand.todo_datasource.Daos.TaskDao
import com.ehsankolivand.todo_datasource.database.TaskDataBase
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class DatabaseUnitTestClass {
    private lateinit var taskDao: TaskDao
    private lateinit var taskDataBase: TaskDataBase

    @Before
    fun createDatabase()
    {
        val context = ApplicationProvider.getApplicationContext<Context>()
        taskDataBase = Room.inMemoryDatabaseBuilder(context,
        TaskDataBase::class.java).build()
        taskDao = taskDataBase.getDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDatabase()
    {
        taskDataBase.close()
    }

    @Test
    fun writeTaskAndThenReadIt()
    {
        val taskDatabaseEntity = TaskDatabaseEntity("ehsam")

        taskDao.insert(taskDatabaseEntity)
        val tasks:List<TaskDatabaseEntity> = taskDao.getAllTasks()

        assertThat(tasks[0].name,equalTo(taskDatabaseEntity.name))


    }


/*
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.ehsankolivand.todo_datasource.test", appContext.packageName)
    }*/
}