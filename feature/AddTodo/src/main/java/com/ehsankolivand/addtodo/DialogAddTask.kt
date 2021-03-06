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
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import java.util.*


@AndroidEntryPoint
class DialogAddTask : BottomSheetDialogFragment(), DatePickerDialog.OnDateSetListener {

    val addTaskViewModel: AddTaskViewModel by viewModels()

    lateinit var binding: DialogAddTaskBinding
    lateinit var dpd: DatePickerDialog
    lateinit var now: Calendar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogAddTaskBinding.inflate(inflater)
        initDateDialog()
        initclickListinners()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }


    private fun initclickListinners() {
        binding.btnAdd.setOnClickListener {
            val str = binding.etTask.text
            if (str.isEmpty()) {
                Toast.makeText(requireContext(), "please add a text", Toast.LENGTH_SHORT).show()
            } else {

                addTaskViewModel.addNewTask(TaskDatabaseEntity(str.toString()))

                this.dismiss()

            }

            binding.btnTime.setOnClickListener {

                dpd.show(parentFragmentManager, "show")


            }
        }
    }

    private fun initDateDialog() {
        now = Calendar.getInstance()
        dpd = DatePickerDialog.newInstance(
            this,
            now.get(Calendar.YEAR),  // Initial year selection
            now.get(Calendar.MONTH),  // Initial month selection
            now.get(Calendar.DAY_OF_MONTH) // Inital day selection
        )
    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {

    }
}