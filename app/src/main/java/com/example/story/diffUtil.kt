package com.example.story

import androidx.recyclerview.widget.DiffUtil

class ItemDiffCallbackHistory : DiffUtil.ItemCallback<History>() {
    override fun areItemsTheSame(
        oldItem: History,
        newItem: History
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: History,
        newItem: History
    ): Boolean {
        return oldItem == newItem
    }
}