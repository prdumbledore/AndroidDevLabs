package com.example.androiddevlab5

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

class CoroutineActivity : AppCompatActivity() {
    private var secondsElapsed = 0
    private lateinit var textSecondsElapsed: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_executor)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)

        lifecycleScope.launchWhenResumed {
            while (isActive) {
                Log.d("CoroutineActivity", "${Thread.currentThread()}")
                textSecondsElapsed.text = getString(R.string.ElapsedCoroutine, secondsElapsed++)
                delay(1000)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putInt(SEC_ELAPSED, secondsElapsed)
        }
        Log.d("CoroutineActivity", "OnStop $secondsElapsed SEC")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d("CoroutineActivity", "OnStart $secondsElapsed SEC")
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.run {
            secondsElapsed = getInt(SEC_ELAPSED)
        }
    }

    companion object {
        const val SEC_ELAPSED = "seconds"
    }
}