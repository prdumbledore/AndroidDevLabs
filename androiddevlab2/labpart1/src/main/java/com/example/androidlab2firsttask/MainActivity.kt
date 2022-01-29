package com.example.androidlab2firsttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LIFECYCLE_CALLBACKS,"onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        Log.d(LIFECYCLE_CALLBACKS,"onStart")
        super.onStart()
    }

    override fun onRestart() {
        Log.d(LIFECYCLE_CALLBACKS,"onRestart")
        super.onRestart()
    }

    override fun onPause() {
        Log.d(LIFECYCLE_CALLBACKS,"onPause")
        super.onPause()
    }

    override fun onDestroy(){
        Log.d(LIFECYCLE_CALLBACKS,"onDestroy")
        super.onDestroy()
    }

    override fun onResume() {
        Log.d(LIFECYCLE_CALLBACKS,"onResume")

        super.onResume()
    }

    override fun onStop() {
        Log.d(LIFECYCLE_CALLBACKS,"onStop")
        super.onStop()
    }

    companion object {
        const val LIFECYCLE_CALLBACKS = "lifecycle log"
    }
}
