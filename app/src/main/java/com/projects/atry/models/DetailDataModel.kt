package com.projects.atry.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class DetailDataModel(
    @SerializedName("talkId")
    val talkId:String,

    @SerializedName("title")
    val title:String,

    @SerializedName("age")
    val age:String,

    @SerializedName("time")
    val time:String,

    @SerializedName("userAvatar")
    val userAvatar:String,

    @SerializedName("userName")
    val userName:String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(talkId)
        parcel.writeString(title)
        parcel.writeString(age)
        parcel.writeString(time)
        parcel.writeString(userAvatar)
        parcel.writeString(userName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DetailDataModel> {
        override fun createFromParcel(parcel: Parcel): DetailDataModel {
            return DetailDataModel(parcel)
        }

        override fun newArray(size: Int): Array<DetailDataModel?> {
            return arrayOfNulls(size)
        }
    }
}
