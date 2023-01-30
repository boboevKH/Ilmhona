package com.example.story.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.story.R
import com.example.story.RVAdapter
import com.example.story.model.History
import com.example.story.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val viewmodel = MyViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(
        this, LinearLayoutManager.HORIZONTAL,false)

        val adapter = RVAdapter()
        adapter.onItemClick = {
            adapter.submitList(viewmodel.getNewData(it.id))
        }
        adapter.submitList(viewmodel.getNewData())
        recyclerView.adapter = adapter
    }



}