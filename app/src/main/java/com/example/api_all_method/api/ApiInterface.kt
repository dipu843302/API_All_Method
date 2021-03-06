package com.example.api_all_method.api

import com.example.api_all_method.model.User
import com.example.api_all_method.model.UserList
import com.example.api_all_method.model.UserUpdate
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    //https://gorest.co.in/public/v2/users
    @GET("users")
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json",
        "Authorization: Bearer 31dbc54e6d9d7680cda71286781164fbdeced7dafb33250ca119a2bbcbaa99b4"
    )
    fun getUserList(): Call<UserList>

    @POST("users")
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json",
        "Authorization: Bearer 31dbc54e6d9d7680cda71286781164fbdeced7dafb33250ca119a2bbcbaa99b4"
    )
   
     fun createUser(@Body params: User): Call<User>

    @DELETE("users/{user_id}")
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json",
        "Authorization: Bearer 31dbc54e6d9d7680cda71286781164fbdeced7dafb33250ca119a2bbcbaa99b4"
    )
     fun deleteUser(@Path("user_id") user_id:Int):Call<User>

    @PUT("users/{user_id}")
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json",
        "Authorization: Bearer 31dbc54e6d9d7680cda71286781164fbdeced7dafb33250ca119a2bbcbaa99b4"
    )
     fun updateData(@Path("user_id") user_id: Int,@Body userUpdate: UserUpdate):Call<User>





//    //   https://gorest.co.in/public/v2/users?name=a
//    @GET("users")
//    @Headers("Accept:application/json", "Content-Type:application/json")
//    fun searchUser(@Query("name") searchText: String): Call<UserList>
//
//    //https://gorest.co.in/public/v2/users/121
//    @GET("users/{user_id}")
//    @Headers("Accept:application/json", "Content-Type:application/json")
//    fun getUser(@Path("user_id") user_id: String): Call<UserList>

//
//    @PATCH("users/{user_id}")
//    @Headers(
//        "Accept:application/json",
//        "Content-Type:application/json",
//        "Authorization: Bearer 31dbc54e6d9d7680cda71286781164fbdeced7dafb33250ca119a2bbcbaa99b4"
//    )
//    fun updateUser(@Path("user_id") user_id: String, @Body params: User): Call<UserResponse>
//

}