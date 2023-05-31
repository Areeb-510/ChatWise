package com.example.chatwisetask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatwisetask.adapter.PictureAdapter
import com.example.chatwisetask.api.PictureService
import com.example.chatwisetask.api.RetrofitHelper
import com.example.chatwisetask.repository.PictureRepository
import com.example.chatwisetask.viewmodels.PictureViewModel
import com.example.chatwisetask.viewmodels.PictureViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity2 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter : PictureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = PictureAdapter()

        val BASE_URL = "https://jsonplaceholder.typicode.com"

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val dataService = retrofit.create(PictureService::class.java)

        val dataRepository = PictureRepository(dataService)
        val viewModel = ViewModelProvider(this, PictureViewModelFactory(dataRepository)).get(PictureViewModel::class.java)



        viewModel.pictures.observe(this, Observer {
            adapter.setData(it)
        })


        recyclerView.adapter = adapter


    }
}