package com.example.chatwisetask.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatwisetask.data.Picture
import com.example.chatwisetask.repository.PictureRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PictureViewModel(private val repository: PictureRepository) : ViewModel() {


    var pictures : LiveData<List<Picture>> = repository.pictureList

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.fetchData()
        }

        pictures = repository.pictureList

    }
}