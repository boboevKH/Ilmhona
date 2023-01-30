package com.example.story

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.story.model.History
import com.google.android.material.imageview.ShapeableImageView

class RVAdapter: ListAdapter <History, RVAdapter.ViewHolder> (

ItemDiffCallbackHistory()
        ){
        var onItemClick: ((History) -> Unit)? = null

        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
                val image = itemView.findViewById<ShapeableImageView>(R.id.shpb_img)

                init {
                        itemView.setOnClickListener {
                                onItemClick?.invoke(getItem(adapterPosition))
                        }
                }

                fun configure(history: History)  {
                        image.setImageResource(history.image)

                        if(history.isWatched) image.strokeWidth = 0F else image.strokeWidth = 10F
                }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                val view = layoutInflater.inflate(R.layout.fragment_history, parent, false)

                return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.configure(getItem(position))
        }


}