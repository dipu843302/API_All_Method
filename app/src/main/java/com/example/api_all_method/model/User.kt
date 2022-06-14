package com.example.api_all_method.model


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    val email: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("id")
    val id: Int?=null,
    @SerializedName("name")
    val name: String?,
    @SerializedName("status")
    val status: String?
)