package com.example.goallist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.goallist.databinding.FragmentGoalListBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.Observer
import com.example.goallist.view.GoalAdapter

@AndroidEntryPoint
class GoalListFragment : Fragment() {

    private  var _listOfGoalBinding: FragmentGoalListBinding?=null

    private val binding get() = _listOfGoalBinding!!


    private val goalListViewModel:GoalViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _listOfGoalBinding =
            FragmentGoalListBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        goalListViewModel.goalObservable.observe(requireActivity(), Observer {
            val adapter = GoalAdapter()

            adapter.setData(it)

            binding.todoGoalRecyclerview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            binding.todoGoalRecyclerview.setHasFixedSize(true)
            binding.todoGoalRecyclerview.isNestedScrollingEnabled = true
            binding.todoGoalRecyclerview.adapter = adapter

        })

        binding.todoGoalRecyclerview.setOnClickListener {

        }


    }

}