package com.ehsankolivand.todo_datasource.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

data class  Dispatcher @Inject constructor(
    val iO: CoroutineDispatcher,
    val main: CoroutineDispatcher
)