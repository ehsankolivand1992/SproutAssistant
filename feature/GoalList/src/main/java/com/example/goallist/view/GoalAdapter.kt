package com.example.goallist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ehsankolivand.todo_datasource.entity.GoalEntity
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import com.example.goallist.databinding.GoalItemBinding


class GoalAdapter() : RecyclerView.Adapter<GoalAdapter.ViewHolder>() {

    lateinit var listOfGoals:List<GoalEntity>

    inner class ViewHolder(val binding: GoalItemBinding)
        : RecyclerView.ViewHolder(binding.root)




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding =
            GoalItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    fun setData(list: List<GoalEntity>)
    {
        this.listOfGoals = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtTitle.text = this.listOfGoals[position].goal
    }

    override fun getItemCount(): Int {
        return if (listOfGoals.isNotEmpty()) {
            listOfGoals.size
        }else{
            0
        }
    }
}