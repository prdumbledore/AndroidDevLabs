package com.example.part2

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class MainActivity(@LayoutRes private val res: Int) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(res)

        findViewById<BottomNavigationView>(R.id.nav_view)?.setOnItemSelectedListener {
            toAbout(it)
        }
    }

    private fun toAbout(menuItem: MenuItem): Boolean {
        return if (menuItem.itemId == R.id.navigation_about) {
            startActivity(Intent(this, AboutActivity::class.java))
            true
        } else false
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}