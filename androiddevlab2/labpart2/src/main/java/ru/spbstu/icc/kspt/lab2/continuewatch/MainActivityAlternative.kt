package ru.spbstu.icc.kspt.lab2.continuewatch

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivityAlternative : AppCompatActivity() {

    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView
    private var stopCounter = true
    private lateinit var sharedPref: SharedPreferences

    private var backgroundThread = Thread {
        while (true) {
            if (stopCounter) {
                textSecondsElapsed.post {
                    textSecondsElapsed.text = getString(R.string.SecElapsed, secondsElapsed++)
                }
                Thread.sleep(1000)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        sharedPref = getSharedPreferences(SEC_ELAPSED, Context.MODE_PRIVATE)
        backgroundThread.start()
    }

    override fun onPause() {
        super.onPause()
        stopCounter = false
    }
    override fun onStop() {
        super.onStop()
        stopCounter = false
        sharedPref.edit().run {
            putInt(SEC_ELAPSED, secondsElapsed)
            apply()
        }
    }

    override fun onResume() {
        secondsElapsed = sharedPref.getInt(SEC_ELAPSED, 0)
        super.onResume()
        stopCounter = true
    }

    override fun onStart() {
        super.onStart()
        stopCounter = true
    }

    companion object{
        const val SEC_ELAPSED = "seconds"
    }
}