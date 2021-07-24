package com.ehsankolivand.tododetails

import android.R
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ehsankolivand.extensions.toTime
import com.ehsankolivand.tododetails.databinding.FragmentPomodoroBinding


class PomodoroFragment : Fragment() {
    lateinit var binding:FragmentPomodoroBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPomodoroBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var countDownTimer: CountDownTimer = timer()

        binding.btnStart.setOnClickListener {
            countDownTimer.start()
        }
        binding.btnStop.setOnClickListener {
            countDownTimer.cancel()
        }
    }

    inner class timer : CountDownTimer(90000,1000) {
        override fun onTick(millisUntilFinished: Long) {
            binding.etTimer.setText(millisUntilFinished.toTime())
        }

        override fun onFinish() {
        }

    }
}