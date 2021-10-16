package com.ehsankolivand.tododetails.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import com.ehsankolivand.todo_datasource.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class InfoViewModel @Inject constructor(private val todoRepo: TodoRepository): ViewModel() {


    private val _taskDateObservable = MutableLiveData<TaskDatabaseEntity>()
    val taskObservable: LiveData<TaskDatabaseEntity> = _taskDateObservable


    fun updateInfo(task: TaskDatabaseEntity)
    {
        todoRepo.insertOrUpdate(task)
    }
    fun fatch(task: TaskDatabaseEntity)
    {
        _taskDateObservable.value = todoRepo.search(task)
    }
}