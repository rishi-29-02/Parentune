package com.projects.atry.models

import com.google.gson.annotations.SerializedName

data class CommentModel(

    @SerializedName("userName")
    val userName:String,

    @SerializedName("userDetail")
    val userDetail:String,

    @SerializedName("userAvatar")
    val userAvatar:String,

    @SerializedName("comment")
    val comment:String
)
