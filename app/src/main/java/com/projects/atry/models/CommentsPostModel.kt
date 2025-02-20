package com.projects.atry.models

import com.google.gson.annotations.SerializedName

data class CommentsPostModel(
    @SerializedName("itemType")
    val itemType: String,

    @SerializedName("comment")
    val comment: String,

    @SerializedName("parentItemType")
    val parentItemType: String,

    @SerializedName("parentItemId")
    val parentItemId: Int,

    @SerializedName("sticker_id")
    val stickerId: String,

    @SerializedName("itemId")
    val itemId: Int,

    @SerializedName("commentType")
    val commentType: String
)
