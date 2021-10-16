package com.ehsankolivand.tododetails.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ehsankolivand.tododetails.DetailsFragment
import com.ehsankolivand.tododetails.InfoFragment
import com.ehsankolivand.tododetails.PomodoroFragment

class extraDetailsAdapter constructor(fragment: DetailsFragment):
    FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when(position)
        {
            0-> return InfoFragment()
            1-> return PomodoroFragment()
        }
        return InfoFragment()
    }


}