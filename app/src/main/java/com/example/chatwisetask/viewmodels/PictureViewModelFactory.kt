package com.example.chatwisetask.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chatwisetask.repository.PictureRepository

class PictureViewModelFactory(private val repository: PictureRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PictureViewModel(repository) as T
    }
}