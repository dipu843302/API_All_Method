package com.example.api_all_method.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.api_all_method.api.ApiInterface
import com.example.api_all_method.api.Network
import com.example.api_all_method.model.User
import com.example.api_all_method.model.UserList
import com.example.api_all_method.model.UserUpdate
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyRepository(private val api: ApiInterface) {

    private val myLiveData: MutableLiveData<UserList> = MutableLiveData()

    var createNewUserLiveData: MutableLiveData<User> = MutableLiveData()

    fun getData(): LiveData<UserList> {
        return myLiveData
    }

    fun getResult() = createNewUserLiveData

    fun getMyData() {
        api.getUserList().enqueue(object : Callback<UserList> {
            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                myLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<UserList>, t: Throwable) {
                Log.d("failure", t.toString())
            }
        })
    }


    fun deleteData(id: Int) {
        api.deleteUser(id).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                createNewUserLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("failure", t.toString())
            }
        })
    }

    fun updateData(id: Int, userUpdate: UserUpdate) {
       CoroutineScope(Dispatchers.IO).launch {
            try{
                val response= api.updateData(id,userUpdate).execute()
                if (response.isSuccessful){
                    createNewUserLiveData.postValue(response.body())
                }
            }catch (e:Exception){
                Log.e("failed","${e.toString()}")
            }
        }
    }
    fun createData(user: User){
         CoroutineScope(Dispatchers.IO).launch {
             val response=api.createUser(user).execute()
             createNewUserLiveData.postValue(response.body())
         }
    }
}