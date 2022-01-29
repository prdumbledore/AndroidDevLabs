package com.example.part5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.part5.databinding.FragmentSecondBinding

class SecondFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSecondBinding.inflate(layoutInflater)
        val navController = findNavController()

        binding.bnToFirst.setOnClickListener {
            navController.navigate(R.id.action_second_to_first)
        }

        binding.bnToThird.setOnClickListener {
            navController.navigate(R.id.action_second_to_third)
        }

        return binding.root
    }

}