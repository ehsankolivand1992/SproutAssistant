package com.ehsankolivand.addtodo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import com.ehsankolivand.todo_datasource.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.withTestContext
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class AddTaskViewModel @Inject constructor(private val repository: TodoRepository) : ViewModel() {

     fun addNewTask(task: TaskDatabaseEntity)
    {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.insertOrUpdate(task)
            }
        }

    }
}