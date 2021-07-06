package com.ehsankolivand.tododetails.adapter

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ehsankolivand.tododetails.DetailsFragment
import com.ehsankolivand.tododetails.one
import com.ehsankolivand.tododetails.two

class extraDetailsAdapter constructor(fragment: DetailsFragment): FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when(position)
        {
            0-> return one()
            1-> return two()
        }
        return one()
    }


}