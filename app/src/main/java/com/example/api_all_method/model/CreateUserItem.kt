package com.example.api_all_method.model


import com.google.gson.annotations.SerializedName

data class CreateUserItem(
    @SerializedName("body")
    val body: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("user_id")
    val userId: Int?
)