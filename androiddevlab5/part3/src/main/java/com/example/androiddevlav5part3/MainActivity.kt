package com.example.androiddevlav5part3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.imageView)

        if (imageView.drawable == null) {
            MainView().apply {
                bitmapData.observe(this@MainActivity) {
                    if (it != null) {
                        imageView.setImageBitmap(it)
                    }
                }
                loadImage()
            }
        }
    }
}