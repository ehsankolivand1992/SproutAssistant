package com.example.addgoal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ehsankolivand.todo_datasource.entity.GoalEntity
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import com.example.addgoal.databinding.DialogAddGoalBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import java.util.*


@AndroidEntryPoint
class DialogAddGoal : BottomSheetDialogFragment(){

    val addTaskViewModel: AddGoalViewModel by viewModels()

    lateinit var binding: DialogAddGoalBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DialogAddGoalBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val now: Calendar = Calendar.getInstance()


        binding.btnAdd.setOnClickListener {
            val str =  binding.etTask.text
            if (str.isEmpty())
            {
                Toast.makeText(requireContext(),"please add a text",Toast.LENGTH_SHORT).show()
            }else{

                addTaskViewModel.addNewGoal(GoalEntity(0,str.toString(),"","",""))
                this.dismiss()
                findNavController().popBackStack()
            }

            binding.btnTime.setOnClickListener {


            }
        }

    }


}