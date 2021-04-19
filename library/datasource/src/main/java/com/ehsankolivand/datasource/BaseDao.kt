package com.ehsankolivand.datasource


import androidx.room.*


abstract class BaseDao<T> {

    @Insert
    abstract suspend fun insert(entity: T): Long

    @Insert
    abstract suspend fun insertAll(vararg entity: T)

    @Insert
    abstract suspend fun insertAll(entities: List<T>)

    @Update
    abstract suspend fun update(entity: T)

    @Delete
    abstract suspend fun deleteEntity(entity: T): Int

    @Transaction
    open suspend fun withTransaction(tx: suspend () -> Unit) = tx()

    abstract suspend fun InsertOrupdate(entity: T)




}
