package com.example.api_all_method.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.api_all_method.api.RetroService

class MyRepository(private val apiInterface: RetroService) {

//    private val myLiveData: MutableLiveData<MyData> = MutableLiveData()
//
//    fun getData(): LiveData<MyData> {
//        return myLiveData
//    }
//
//    suspend fun getMyData() {
//        val result = apiInterface.getData()
//        if (result.body() != null) {
//            myLiveData.postValue(result.body())
//        }
//    }
}