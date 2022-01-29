package com.example.part2

import android.content.Intent
import android.os.Bundle
import android.view.View

class FirstActivity : MainActivity(R.layout.first_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<View>(R.id.bnToSecond).setOnClickListener {
            toSecond()
        }
    }

    private fun toSecond() {
        startActivity(Intent(this, SecondActivity::class.java))
    }


}