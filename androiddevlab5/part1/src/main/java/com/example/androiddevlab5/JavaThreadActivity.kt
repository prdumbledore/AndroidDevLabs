package com.example.androiddevlab5

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class JavaThreadActivity : AppCompatActivity() {

    private var secondsElapsed = 0
    private lateinit var textSecondsElapsed: TextView
    private lateinit var backgroundThread : Thread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_thread)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
    }

    override fun onStart() {
        super.onStart()
        Log.d("JavaThreadActivity", "OnStart $secondsElapsed SEC")
        backgroundThread = getCountingThread()
        backgroundThread.start()
    }

    override fun onStop() {
        super.onStop()
        Log.d("JavaThreadActivity", "OnStop $secondsElapsed SEC")
        backgroundThread.interrupt()
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

    private fun getCountingThread(): Thread = Thread {
        while (!Thread.currentThread().isInterrupted) {
            Log.d("JavaThreadActivity", "${Thread.currentThread()}")
            try {
                textSecondsElapsed.post {
                    textSecondsElapsed.text = getString(R.string.ElapsedJavaThread, secondsElapsed++)
                }
                Thread.sleep(1000)
            }
            catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
            }
        }
    }

    companion object {
        const val SEC_ELAPSED = "seconds"
    }
}