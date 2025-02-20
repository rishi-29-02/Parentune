package com.projects.atry.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TalkListListModel(

    @SerializedName("list")
    val list : ArrayList<TalkListLineModel>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        arrayListOf<TalkListLineModel>().apply {
            parcel.readList(this, TalkListModel::class.java.classLoader)
        }
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeList(list)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TalkListListModel> {
        override fun createFromParcel(parcel: Parcel): TalkListListModel {
            return TalkListListModel(parcel)
        }

        override fun newArray(size: Int): Array<TalkListListModel?> {
            return arrayOfNulls(size)
        }
    }
}
