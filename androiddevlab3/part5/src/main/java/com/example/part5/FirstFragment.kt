package com.example.part5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.part5.databinding.FragmentFirstBinding

class FirstFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFirstBinding.inflate(layoutInflater)
        val navController = findNavController()

        binding.bnToSecond.setOnClickListener {
            navController.navigate(R.id.action_first_to_second)
        }

        return binding.root
    }
}