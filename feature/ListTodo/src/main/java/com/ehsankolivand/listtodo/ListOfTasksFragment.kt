package com.ehsankolivand.listtodo

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ehsankolivand.listtodo.databinding.FragmentListOfTasksBinding
import com.ehsankolivand.listtodo.view.TaskAdapter
import com.ehsankolivand.todo_datasource.entity.TaskDatabaseEntity
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * create an instance of this fragment.
 */

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


        //val componentManager: ListViewModel by viewModels()

             listViewModel.taskObservable.observe(requireActivity(), Observer {
                 val adapter = TaskAdapter()
                 adapter.setData(it)
                 binding.todoListRecycler.layoutManager = LinearLayoutManager(requireContext())
                 binding.todoListRecycler.adapter = adapter
             })

    }
}