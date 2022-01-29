package com.example.part2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class SecondActivity : MainActivity(R.layout.activity_second) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<View>(R.id.bnToFirst).setOnClickListener {
            toFirst()
        }

        findViewById<View>(R.id.bnToThird).setOnClickListener {
            toThird()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_CODE && resultCode == Activity.RESULT_OK) {
            finish()
        }
    }

    private fun toFirst() {
        finish()
    }

    private fun toThird() {
        startActivityForResult(Intent(this, ThirdActivity::class.java), RESULT_CODE)
    }

    companion object {
        const val RESULT_CODE = 0
    }

}