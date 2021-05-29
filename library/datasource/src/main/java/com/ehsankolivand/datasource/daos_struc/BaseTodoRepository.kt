package com.ehsankolivand.datasource.daos_struc

import kotlinx.coroutines.flow.Flow



interface BaseTodoRepository<T> {

    fun getAll():Flow<List<T>>

     fun search(entity:T):T

    suspend fun insertOrUpdate(entity: T)



}