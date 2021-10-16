package com.example.shared_ui.adapters.dialogs

import android.R
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shared_ui.adapters.GoalAdapter
import com.example.shared_ui.adapters.StickerPickerAdapter
import com.example.shared_ui.adapters.enums.Images
import com.example.shared_ui.databinding.TaskDialogBinding


class EditNameDialogFragment : DialogFragment() {

    lateinit var _binding:TaskDialogBinding
    lateinit var stickerAdapter:StickerPickerAdapter
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding= TaskDialogBinding.inflate(LayoutInflater.from(context))


        return AlertDialog.Builder(requireActivity())
            .setView(_binding.root)
            .create()



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        stickerAdapter = StickerPickerAdapter()


        val image:List<Int> = listOf(
            com.example.shared_ui.R.drawable.ic_birth,
            com.example.shared_ui.R.drawable.ic_buy,
            com.example.shared_ui.R.drawable.ic_class,
            com.example.shared_ui.R.drawable.ic_contact,
            com.example.shared_ui.R.drawable.ic_contact2,
            com.example.shared_ui.R.drawable.ic_debit,
            com.example.shared_ui.R.drawable.ic_drink,
            com.example.shared_ui.R.drawable.ic_eat,
            com.example.shared_ui.R.drawable.ic_learning,
            com.example.shared_ui.R.drawable.ic_sell,
            com.example.shared_ui.R.drawable.ic_telephone,
            com.example.shared_ui.R.drawable.ic_uni,
            com.example.shared_ui.R.drawable.ic_wine,
            com.example.shared_ui.R.drawable.ic_web
        )
        stickerAdapter.setData(image)
        _binding.rcycSticker.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        _binding.rcycSticker.setHasFixedSize(true)
        _binding.rcycSticker.isNestedScrollingEnabled = true
        _binding.rcycSticker.adapter = stickerAdapter
        stickerAdapter.setData(image)




    }




}