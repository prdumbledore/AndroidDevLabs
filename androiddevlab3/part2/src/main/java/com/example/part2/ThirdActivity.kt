package com.example.part2

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : MainActivity(R.layout.activity_third) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<View>(R.id.bnToFirst).setOnClickListener {
            toFirst()
        }

        findViewById<View>(R.id.bnToSecond).setOnClickListener {
            toSecond()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun toFirst() {
        this.setResult(Activity.RESULT_OK)
        finish()
    }

    private fun toSecond() {
        finish()
    }

}