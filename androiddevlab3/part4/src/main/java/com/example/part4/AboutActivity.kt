package com.example.part4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.part4.databinding.ActivityAboutBinding
import com.example.part4.databinding.ActivityFirstBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toThird.setOnClickListener {
            toThird()
        }

        binding.navigationAbout.setOnItemSelectedListener {
            toAbout(it)
        }
    }

    private fun toThird() {
        startActivity(Intent(this, ThirdActivity::class.java))
    }

    private fun toAbout(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.navigation_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
            }
        }
        return false
    }
}