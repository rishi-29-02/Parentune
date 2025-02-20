package com.projects.atry.models

import com.google.gson.annotations.SerializedName

data class UserProfileModel(

    @SerializedName("message")
    val message:String,

    @SerializedName("data")
    val data : UserProfileDetailModel
)
