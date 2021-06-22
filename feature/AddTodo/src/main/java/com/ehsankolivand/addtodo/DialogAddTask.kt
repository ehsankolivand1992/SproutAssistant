package com.ehsankolivand.addtodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ehsankolivand.addtodo.databinding.DialogAddTaskBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DialogAddTask : BottomSheetDialogFragment() {
    lateinit var binding: DialogAddTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DialogAddTaskBinding.inflate(inflater)
        return binding.root
    }
}