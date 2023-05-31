package com.example.chatwisetask.api

import com.example.chatwisetask.data.DataResponse
import com.example.chatwisetask.data.Picture
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PictureService {

    @GET("/photos")
    suspend fun getPictures() : Response<List<Picture>>

}


