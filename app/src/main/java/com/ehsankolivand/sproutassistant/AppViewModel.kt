package com.ehsankolivand.sproutassistant

import android.util.Log
import androidx.lifecycle.*
import com.ehsankolivand.sproutassistant.abstraction.IAppViewModel
import com.ehsankolivand.sproutassistant.abstraction.Router
import com.ehsankolivand.todo_datasource.entity.BaseTodoEntity
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import com.ehsankolivand.todo_datasource.repository.BaseTodoRepository
import com.ehsankolivand.todo_datasource.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class AppViewModel @Inject constructor(private val repository: BaseTodoRepository) :
    ViewModel(),IAppViewModel<BaseTodoEntity> {

    private val _BaseTodoDateObservable = MutableLiveData<List<BaseTodoEntity>>()
    val BaseTodoObservable: LiveData<List<BaseTodoEntity>> = _BaseTodoDateObservable

    init {
        viewModelScope.launch {
            getAll()
        }
    }





    override suspend fun getAll() {
        repository.getAllBaseTodo().collect {
            _BaseTodoDateObservable.postValue(it)
        }
    }









     override fun insert(taskDatabaseEntity: BaseTodoEntity)
    {
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                repository.insertBaseTodo(taskDatabaseEntity)
            }
        }
    }



    override fun update(entity: BaseTodoEntity) {
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                repository.updateBaseTodo(entity)
            }
        }
    }


    override fun delete(entity: BaseTodoEntity) {
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                repository.deleteBaseTodo(entity)
            }
        }
    }






    companion object {
        private const val UPDATE_DELAY_IN_MILLIS = 100L
    }





}
