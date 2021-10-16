package com.example.goallist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ehsankolivand.todo_datasource.entity.GoalEntity
import com.ehsankolivand.todo_datasource.repository.GoalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
@HiltViewModel
class GoalViewModel @Inject constructor(val repository: GoalRepository): ViewModel() {

    private val _GoslDateObservable = MutableLiveData<List<GoalEntity>>()
    val goalObservable: LiveData<List<GoalEntity>> = _GoslDateObservable


    init {
        viewModelScope.launch {
            fetchGoal()
        }
    }


    private suspend fun fetchGoal()
    {
        repository.getAllGoal().collect {
            _GoslDateObservable.postValue(it)
        }
    }


    fun insert(goalDatabaseEntity: GoalEntity)
    {

        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                repository.insertGoal(goalDatabaseEntity)
            }
        }
    }


    fun update(goalDatabaseEntity: GoalEntity)
    {

        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                repository.updateGoal(goalDatabaseEntity)
            }
        }
    }



    companion object {
        private const val UPDATE_DELAY_IN_MILLIS = 100L
    }

}