package com.ehsankolivand.tododetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ehsankolivand.tododetails.databinding.FragmentInfoBinding
import com.ehsankolivand.tododetails.viewModels.InfoViewModel
import dagger.hilt.android.AndroidEntryPoint


class InfoFragment : Fragment() {

    lateinit var binding: FragmentInfoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(inflater)
        return binding.root
    }


}