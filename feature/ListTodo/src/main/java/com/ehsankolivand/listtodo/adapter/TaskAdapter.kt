package com.ehsankolivand.listtodo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ehsankolivand.listtodo.databinding.TaskItemBinding
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity


class TaskAdapter(private val onItemClicked: (TaskDatabaseEntity) -> Unit
) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    lateinit var listOfTasks:List<TaskDatabaseEntity>

    inner class ViewHolder(val binding: TaskItemBinding)
        : RecyclerView.ViewHolder(binding.root){
            init {
                itemView.setOnClickListener{
                    onItemClicked(listOfTasks[adapterPosition])
                }
            }
        }




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
        holder.binding.task.text = listOfTasks[position].name
        holder.binding.root.setOnClickListener {  onItemClicked( listOfTasks[position])}
    }

    override fun getItemCount(): Int {
        return if (listOfTasks.isNotEmpty()) {
            listOfTasks.size
        }else{
            0
        }
    }

}