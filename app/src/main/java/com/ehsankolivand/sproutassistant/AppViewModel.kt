package com.ehsankolivand.sproutassistant

import android.util.Log
import androidx.lifecycle.*
import com.ehsankolivand.sproutassistant.abstraction.IAppViewModel
import com.ehsankolivand.sproutassistant.abstraction.Router
import com.ehsankolivand.todo_datasource.entity.GoalEntity
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import com.ehsankolivand.todo_datasource.repository.GoalRepository
import com.ehsankolivand.todo_datasource.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class AppViewModel @Inject constructor(private val repository: GoalRepository) : ViewModel(),IAppViewModel<GoalEntity> {

    private val _goalDateObservable = MutableLiveData<List<GoalEntity>>()
    val goalObservable: LiveData<List<GoalEntity>> = _goalDateObservable

    init {
        viewModelScope.launch {
            getAll()
        }
    }



    override suspend fun getAll() {
        repository.getAllGoal().collect {
            _goalDateObservable.postValue(it)
        }
    }








     override fun insert(taskDatabaseEntity: GoalEntity)
    {
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                repository.insertGoal(taskDatabaseEntity)
            }
        }
    }

    override fun update(entity: GoalEntity) {
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                repository.updateGoal(entity)
            }
        }
    }

    override fun delete(entity: GoalEntity) {
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                repository.deleteGoal(entity)
            }
        }
    }






    companion object {
        private const val UPDATE_DELAY_IN_MILLIS = 100L
    }





}
