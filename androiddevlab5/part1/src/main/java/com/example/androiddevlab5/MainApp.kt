package com.example.androiddevlab5

import android.app.Application
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainApp: Application() {
    val executor: ExecutorService = Executors.newSingleThreadExecutor()
}