package com.ehsankolivand.listtodo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ehsankolivand.listtodo.databinding.TaskItemBinding
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity


class TaskAdapter() : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    lateinit var listOfTasks:List<TaskDatabaseEntity>

    inner class ViewHolder(val binding: TaskItemBinding)
        : RecyclerView.ViewHolder(binding.root)




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding =
            TaskItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    fun setData(list: List<TaskDatabaseEntity>)
    {
        this.listOfTasks = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       // holder.binding = listOfTasks[position].name
    }

    override fun getItemCount(): Int {
        return if (listOfTasks.isNotEmpty()) {
            listOfTasks.size
        }else{
            0
        }
    }
}