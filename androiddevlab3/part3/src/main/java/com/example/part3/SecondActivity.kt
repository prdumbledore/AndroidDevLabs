package com.example.part3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.part3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnToFirst.setOnClickListener {
            toFirst()
        }

        binding.bnToThird.setOnClickListener {
            toThird()
        }

        binding.navView.setOnItemSelectedListener {
            toAbout(it)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun toFirst() {
        finish()
    }

    private fun toThird() {
        startActivity(Intent(this, ThirdActivity::class.java))
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