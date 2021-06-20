package com.ehsankolivand.listtodo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import com.ehsankolivand.todo_datasource.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ListViewModel @Inject constructor(private val repository: TodoRepository) :ViewModel() {
    private val _taskDateObservable = MutableLiveData<List<TaskDatabaseEntity>>()
    val taskObservable: LiveData<List<TaskDatabaseEntity>> = _taskDateObservable

    init {
        viewModelScope.launch {
            fetchTasks()
        }
    }


    private suspend fun fetchTasks()
    {
        repository.getAll().collect {
            _taskDateObservable.postValue(it)
        }
    }


   fun insert(taskDatabaseEntity: TaskDatabaseEntity)
    {


        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                repository.insertOrUpdate(taskDatabaseEntity)
            }
        }
    }




    companion object {
        private const val UPDATE_DELAY_IN_MILLIS = 100L
    }

}
