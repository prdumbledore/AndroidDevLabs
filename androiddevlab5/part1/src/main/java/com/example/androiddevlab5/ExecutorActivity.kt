package com.example.androiddevlab5

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.Future

class ExecutorActivity : AppCompatActivity() {
    private var secondsElapsed = 0
    private lateinit var textSecondsElapsed: TextView
    private lateinit var future: Future<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_executor)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
    }

    override fun onStart() {
        super.onStart()
        Log.d("ExecutorActivity", "OnStart $secondsElapsed SEC")
        future = getCountingThread()

    }

    override fun onStop() {
        super.onStop()
        Log.d("ExecutorActivity", "OnStop $secondsElapsed SEC")
        future.cancel(true)
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

    private fun getCountingThread() =
        (application as MainApp).executor.submit {
            while (true) {
                Thread.sleep(1000)
                textSecondsElapsed.post {
                    textSecondsElapsed.text = getString(R.string.ElapsedExecutor, secondsElapsed++)
                }
            }
         }


    companion object {
        const val SEC_ELAPSED = "seconds"
    }
}