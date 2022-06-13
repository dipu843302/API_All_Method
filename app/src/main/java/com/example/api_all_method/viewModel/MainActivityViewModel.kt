package com.example.api_all_method.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_all_method.api.RetroInstance
import com.example.api_all_method.api.RetroService
import com.example.api_all_method.model.UserList
import com.example.api_all_method.repository.MyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(private val myRepository: MyRepository):ViewModel() {

    lateinit var recyclerListData:MutableLiveData<UserList>

    init {
       recyclerListData= MutableLiveData()
        }

   fun getUserListObserverable():MutableLiveData<UserList> {
       return recyclerListData
   }

    fun getUserList(){
       val retroInstance=RetroInstance.getRetrofitInstance().create(RetroService::class.java)
        val call=retroInstance.getUserList()
        call.enqueue(object :Callback<UserList>{
            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
               if (response.isSuccessful){
                   recyclerListData.postValue(response.body())
               }
            }

            override fun onFailure(call: Call<UserList>, t: Throwable) {
                recyclerListData.postValue(null)
            }

        })
    }
}