package com.ehsankolivand.todo_datasource.di

import android.content.Context
import androidx.room.Room
import com.ehsankolivand.todo_datasource.database.TaskDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

   @Singleton
   @Provides
   fun provideDataBase(@ApplicationContext context: Context) =
       Room.databaseBuilder(context,
           TaskDataBase::class.java,"tasks.db").build()

    @Singleton
    @Provides
    fun provideDao(db : TaskDataBase)=db.getDao()


    @Singleton
    @Provides
    fun provideGoalDao(db: TaskDataBase)= db.getGoalDao()

    @Singleton
    @Provides
    fun provideBaseTodoDao(db : TaskDataBase)=db.getBaseTodoDao()

}