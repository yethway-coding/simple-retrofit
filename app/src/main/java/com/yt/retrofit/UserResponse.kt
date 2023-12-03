package com.yt.retrofit

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("data") val id: Int? = 0,
    @SerializedName("email") val email: String? = "",
    @SerializedName("first_name") val first_name: String? = "",
    @SerializedName("last_name") val last_name: String? = "",
    @SerializedName("avatar") val avatar: String? = "",
)
