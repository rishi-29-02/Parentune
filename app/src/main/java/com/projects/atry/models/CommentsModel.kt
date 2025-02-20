package com.projects.atry.models

import com.google.gson.annotations.SerializedName

data class CommentsModel(
    @SerializedName("comments")
    val comments:ArrayList<CommentModel>
)
