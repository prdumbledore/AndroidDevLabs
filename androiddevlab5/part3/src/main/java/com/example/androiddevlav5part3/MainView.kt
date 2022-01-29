package com.example.androiddevlav5part3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainView: ViewModel() {

    val bitmapData = MutableLiveData<Bitmap>()

    fun loadImage() {
        viewModelScope.launch(Dispatchers.IO) {
            val url = URL(URL).openConnection().getInputStream()
            val img = BitmapFactory.decodeStream(url)
            withContext(Dispatchers.Main) { bitmapData.value = img }
        }
    }

    companion object {
        private const val URL = "https://birdinflight.imgix.net/wp-content/uploads/2016/08/this-is-not-fine_cover.jpg?fm=pjpg&q=70&fit=crop&crop=faces&w=630&h=355"
    }
}