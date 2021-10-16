package com.ehsankolivand.sproutassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ComputableLiveData
import androidx.lifecycle.Observer
import com.ehsankolivand.sproutassistant.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.activity.viewModels

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding

    //private val appViewModelFactory:AppViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.root.apply {
            setContentView(this)
        }

    }


}