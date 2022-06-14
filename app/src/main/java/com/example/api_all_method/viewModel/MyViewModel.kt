package com.example.api_all_method.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_all_method.model.CreateUserItem
import com.example.api_all_method.model.User
import com.example.api_all_method.repository.MyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(private val repository: MyRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMyData()
        }
    }

    fun get() = repository.getData()
    fun getResult() = repository.getResult()

    fun createUser(user: User) {
        repository.createData(user)
    }
    fun deleteData(id:Int){
        repository.deleteData(id)
    }
}