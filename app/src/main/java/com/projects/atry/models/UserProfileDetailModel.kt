package com.projects.atry.models

import com.google.gson.annotations.SerializedName

data class UserProfileDetailModel(

    @SerializedName("name")
    val name:String,

    @SerializedName("avatar")
    val avatar:String
)
