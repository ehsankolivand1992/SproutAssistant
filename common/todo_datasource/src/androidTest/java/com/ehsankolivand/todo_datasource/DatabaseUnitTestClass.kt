package com.ehsankolivand.todo_datasource

import android.content.Context
import android.util.Log
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.ehsankolivand.todo_datasource.daos.TaskDao
import com.ehsankolivand.todo_datasource.database.TaskDataBase
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import com.ehsankolivand.todo_datasource.repository.TodoRepository
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

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
    private lateinit var todoRep:TodoRepository
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun createDatabase()
    {
        Dispatchers.setMain(mainThreadSurrogate)
        val context = ApplicationProvider.getApplicationContext<Context>()
        taskDataBase = TaskDataBase.getInstance(context)
        taskDao = taskDataBase.getDao()

        todoRep = TodoRepository(taskDao)
    }

    @After
    @Throws(IOException::class)
    fun closeDatabase()
    {
        Log.i("testttttt","After")

        Dispatchers.resetMain()
        taskDataBase.close()
    }

    @Test
    fun writeTaskAndThenReadIt() {
        runBlocking{
            Log.i("testttttt","Test")

            launch(Dispatchers.Main)
            {
                todoRep.insertOrUpdate(TaskDatabaseEntity("task"))

                todoRep.getAll().map {
                    assertEquals(it[0].name, "task")
                }
            }
        }
    }






    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.ehsankolivand.todo_datasource.test", appContext.packageName)
    }
}
