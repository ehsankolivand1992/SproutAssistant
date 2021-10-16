package com.example.shared_ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import com.example.shared_ui.databinding.TaskItemBinding


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
        holder.binding.txtTitle.text = this.listOfTasks[position].name
    }

    override fun getItemCount(): Int {
        return if (listOfTasks.isNotEmpty()) {
            listOfTasks.size
        }else{
            0
        }
    }
}