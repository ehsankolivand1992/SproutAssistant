package com.ehsankolivand.datasource.daos_struc


import androidx.room.*
import kotlinx.coroutines.flow.Flow


interface BaseDao<T> {

     fun getAll():Flow<List<T>>
     fun getIsDone():Flow<List<T>>
     fun getToCome():Flow<List<T>>
     fun searchById(id:Long):T
      fun insert(entity: T): Long

     suspend fun insertAll(vararg entity: T)

     suspend fun insertAll(entities: List<T>)

     suspend fun update(entity: T)

     suspend fun deleteEntity(entity: T): Int

     suspend fun withTransaction(tx: suspend () -> Unit) = tx()

     suspend fun InsertOrupdate(entity: T)




}