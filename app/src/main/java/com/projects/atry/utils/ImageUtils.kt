package com.projects.atry.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageUtils {

    fun setUserImage(context: Context, avatar: String, view:ImageView) {
        Glide.with(context)
            .load(avatar)
            .circleCrop()
            .into(view)
    }
}