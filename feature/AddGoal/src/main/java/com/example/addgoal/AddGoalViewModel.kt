package com.example.addgoal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ehsankolivand.todo_datasource.entity.GoalEntity
import com.ehsankolivand.todo_datasource.repository.GoalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AddGoalViewModel @Inject constructor(private val repository: GoalRepository) : ViewModel() {

    fun addNewGoal(task: GoalEntity)
    {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.insertGoal(task)
            }
        }

    }
}