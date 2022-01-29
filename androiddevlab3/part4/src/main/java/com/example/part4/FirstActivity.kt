package com.example.part4

import android.view.MenuItem
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.part4.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toSecond.setOnClickListener {
            toSecond()
        }

        binding.navigationAbout.setOnItemSelectedListener {
            toAbout(it)
        }
    }

    private fun toSecond() {
        startActivity(Intent(this, SecondActivity::class.java))
    }

    private fun toAbout(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.navigation_about -> {
                startActivity(Intent(this, AboutActivity::class.java))
            }
        }
        return false
    }
}