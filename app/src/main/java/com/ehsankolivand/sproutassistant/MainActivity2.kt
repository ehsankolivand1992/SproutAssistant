package com.ehsankolivand.sproutassistant

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ComputableLiveData
import androidx.lifecycle.Observer
import com.ehsankolivand.sproutassistant.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.ehsankolivand.constants.database.TaskType
import com.ehsankolivand.sproutassistant.abstraction.Router

@AndroidEntryPoint
class MainActivity2 : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding


    private val appViewModelFactory:AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.root.apply {
            setContentView(this)
        }
/*
        binding.floatingActionButton2.setOnClickListener {
            Log.i("testtest","clicked")
            val uri = Uri.parse("sprout://add-goal")

            binding.fragmentContainerView.findNavController().navigate(uri)
        }
*/


    }


}