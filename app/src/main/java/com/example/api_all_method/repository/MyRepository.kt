package com.example.api_all_method.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.api_all_method.api.ApiInterface
import com.example.api_all_method.model.User
import com.example.api_all_method.model.UserList
import com.example.api_all_method.model.UserUpdate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRepository(private val apiInterface: ApiInterface) {

    private val myLiveData: MutableLiveData<UserList> = MutableLiveData()

    var createNewUserLiveData: MutableLiveData<User> = MutableLiveData()

    fun getData(): LiveData<UserList> {
        return myLiveData
    }

    fun getResult()=createNewUserLiveData

    suspend fun getMyData() {
        val result = apiInterface.getUserList()
        if (result.body() != null) {
            myLiveData.value=(result.body())
        }
    }

    fun createData(user: User){
        CoroutineScope(Dispatchers.IO).launch {
         val response=   apiInterface.createUser(user)
            createNewUserLiveData.postValue(response)
        }
    }

    fun deleteData(id:Int){
        CoroutineScope(Dispatchers.IO).launch {
           apiInterface.deleteUser(id)
        }
    }

    fun updateData(id:Int,userUpdate: UserUpdate){
        CoroutineScope(Dispatchers.IO).launch {
            apiInterface.updateData(id.toString(),userUpdate)
        }
    }
}