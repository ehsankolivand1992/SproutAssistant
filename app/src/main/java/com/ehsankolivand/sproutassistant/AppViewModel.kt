package com.ehsankolivand.sproutassistant

import android.util.Log
import androidx.lifecycle.*
import com.ehsankolivand.sproutassistant.abstraction.IAppViewModel
import com.ehsankolivand.sproutassistant.abstraction.Router
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import com.ehsankolivand.todo_datasource.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class AppViewModel @Inject constructor(private val repository: TodoRepository) : ViewModel(),IAppViewModel {



    private suspend fun fetchTasks()
    {
        repository.getAll().collect {
        }
    }




    override fun insert(taskDatabaseEntity: TaskDatabaseEntity)
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
