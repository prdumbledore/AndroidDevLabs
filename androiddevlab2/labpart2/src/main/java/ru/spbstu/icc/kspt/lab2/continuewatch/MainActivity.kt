package ru.spbstu.icc.kspt.lab2.continuewatch

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView
    private var stopCounter = true

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
        backgroundThread.start()
    }

    override fun onPause() {
        super.onPause()
        stopCounter = false
    }
    override fun onStop() {
        super.onStop()
        stopCounter = false
    }

    override fun onResume() {
        super.onResume()
        stopCounter = true
    }

    override fun onStart() {
        super.onStart()
        stopCounter = true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putInt(SEC_ELAPSED, secondsElapsed)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.run {
            secondsElapsed = getInt(SEC_ELAPSED)
        }
    }
    companion object{
        const val SEC_ELAPSED = "seconds"
    }
}
