package com.example.api_all_method.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.api_all_method.repository.MyRepository

class MyViewModelFactory(private val myRepository: MyRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(myRepository ) as T
    }

}