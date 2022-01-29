package com.example.androiddevlab5part4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView: ImageView = findViewById(R.id.imageView)

        if (imageView.drawable == null) {
            Picasso.get()
                .load(URL)
                .into(imageView)
        }
    }

    companion object {
        private const val URL = "https://birdinflight.imgix.net/wp-content/uploads/2016/08/this-is-not-fine_cover.jpg?fm=pjpg&q=70&fit=crop&crop=faces&w=630&h=355"
    }
}