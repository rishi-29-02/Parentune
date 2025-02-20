package com.projects.atry.models

import com.google.gson.annotations.SerializedName

data class DetailModel(

    @SerializedName("data")
    val data : DetailDataModel
)
