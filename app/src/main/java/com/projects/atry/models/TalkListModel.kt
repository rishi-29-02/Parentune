package com.projects.atry.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TalkListModel(
    @SerializedName("data")
    val data : TalkListListModel
)
