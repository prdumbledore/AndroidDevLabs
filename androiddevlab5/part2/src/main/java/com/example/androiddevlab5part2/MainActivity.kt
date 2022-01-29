package com.example.androiddevlab5part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import java.util.concurrent.ExecutorService
import android.graphics.BitmapFactory
import java.net.URL
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity() {
    private lateinit var imageView : ImageView
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image)
        executor.execute {
            val url = URL(URL)
            val image = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            runOnUiThread { imageView.setImageBitmap(image) }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        executor.shutdown()
    }
    companion object {
        private const val URL = "https://birdinflight.imgix.net/wp-content/uploads/2016/08/this-is-not-fine_cover.jpg?fm=pjpg&q=70&fit=crop&crop=faces&w=630&h=355"
    }

}