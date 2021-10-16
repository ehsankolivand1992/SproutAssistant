package com.example.shared_ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ehsankolivand.todo_datasource.entity.GoalEntity
import com.example.shared_ui.databinding.RvItemGoalBinding

class GoalAdapter: RecyclerView.Adapter<GoalAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: RvItemGoalBinding)
        : RecyclerView.ViewHolder(binding.root)
    lateinit var dataList: List<GoalEntity>
    fun setData(data:List<GoalEntity>)
    {
        dataList = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding = RvItemGoalBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data = this.dataList[position]
        holder.binding.rbGoal.text = data.title
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}