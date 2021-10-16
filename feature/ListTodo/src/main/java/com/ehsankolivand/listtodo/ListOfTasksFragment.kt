package com.ehsankolivand.listtodo

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ehsankolivand.listtodo.databinding.FragmentListOfTasksBinding
import com.ehsankolivand.listtodo.adapter.TaskAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListOfTasksFragment : Fragment() {

    private  var _listOfTasksBinding: FragmentListOfTasksBinding?=null

    private val binding get() = _listOfTasksBinding!!

    private val listViewModel:ListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _listOfTasksBinding =
            FragmentListOfTasksBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _listOfTasksBinding?.button?.setOnClickListener {
            val uri = Uri.parse("sprout://add")
            Navigation.findNavController(view).navigate(uri)

        }

             listViewModel.taskObservable.observe(requireActivity(), Observer {
                 val adapter = TaskAdapter{
                     it ->
                     val uri2 = Uri.parse("sprout://details")
                     Navigation.findNavController(view).navigate(uri2)
                 }
                 adapter.setData(it)

                 binding.todoListRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                 binding.todoListRecycler.setHasFixedSize(true)
                 binding.todoListRecycler.isNestedScrollingEnabled = true
                 binding.todoListRecycler.adapter = adapter

             })

    }


}