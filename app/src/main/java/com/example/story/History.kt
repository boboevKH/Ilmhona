package com.example.story

import android.graphics.drawable.Drawable

data class History(
    var id: Int,
    val image: Drawable?,
    var isWatched: Boolean = false
)
