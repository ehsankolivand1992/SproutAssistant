package com.ehsankolivand.addtodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.ehsankolivand.addtodo.databinding.DialogAddTaskBinding
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DialogAddTask : BottomSheetDialogFragment() {

    val addTaskViewModel: AddTaskViewModel by viewModels()

    lateinit var binding: DialogAddTaskBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DialogAddTaskBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAdd.setOnClickListener {
           val str =  binding.etTask.text
            if (str.isEmpty())
            {
                Toast.makeText(requireContext(),"please add a text",Toast.LENGTH_SHORT).show()
            }else{

                addTaskViewModel.addNewTask(TaskDatabaseEntity(str.toString()))
                this.dismiss()
            }
        }

    }
}