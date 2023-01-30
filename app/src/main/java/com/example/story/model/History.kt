package com.example.story.model

import android.graphics.drawable.Drawable

data class History(
    var id: Int,
    val image: Int,
    var isWatched: Boolean = false
)
