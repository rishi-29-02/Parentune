package com.projects.atry.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TalkListLineModel(
    @SerializedName("talkId")
    val talkId:String,

    @SerializedName("title")
    val title:String,

    @SerializedName("userName")
    val userName:String,

    @SerializedName("userAvatar")
    val userAvatar:String,

    @SerializedName("time")
    val time:String,

    @SerializedName("age")
    val age:String,

    @SerializedName("isNearby")
    val isNearby : Boolean
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(talkId)
        parcel.writeString(title)
        parcel.writeString(userName)
        parcel.writeString(userAvatar)
        parcel.writeString(time)
        parcel.writeString(age)
        parcel.writeByte(if (isNearby) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TalkListLineModel> {
        override fun createFromParcel(parcel: Parcel): TalkListLineModel {
            return TalkListLineModel(parcel)
        }

        override fun newArray(size: Int): Array<TalkListLineModel?> {
            return arrayOfNulls(size)
        }
    }
}
