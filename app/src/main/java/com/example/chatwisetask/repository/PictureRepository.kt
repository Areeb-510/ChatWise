package com.example.chatwisetask.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chatwisetask.api.PictureService
import com.example.chatwisetask.data.Picture

class PictureRepository(private val pictureService: PictureService) {

    private val _pictureList: MutableLiveData<List<Picture>> = MutableLiveData()
    val pictureList: LiveData<List<Picture>> get() = _pictureList

    suspend fun fetchData() {
        val response = pictureService.getPictures()
        if (response.isSuccessful) {
            val dataList = response.body() ?: emptyList()

            // Post the value update to the main thread
            _pictureList.postValue(dataList)
            // Pass the dataList to the appropriate part of your application
        } else {
            // Handle error case
        }
    }
}

