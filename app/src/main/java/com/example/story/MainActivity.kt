package com.example.story

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

   private var newList: List<History> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(
        this, LinearLayoutManager.HORIZONTAL,false)

        val adapter = RVAdapter()
        adapter.onItemClick = {
            adapter.submitList(getNewData(it.id))
        }
        adapter.submitList(getNewData())
        recyclerView.adapter = adapter
    }


    fun getNewData(id: Int? = null) : MutableList<History> {
        var list = mutableListOf(
            History(1,getDrawable(R.drawable.ic_launcher_background)),
            History(2,getDrawable(R.drawable.ic_launcher_background)),
            History(3,getDrawable(R.drawable.ic_launcher_background)),
            History(4, getDrawable(R.drawable.ic_launcher_background)),
            History(5, getDrawable(R.drawable.ic_launcher_background)),
        )
        newList.forEachIndexed{ ind, history ->
                list[ind].isWatched = history.isWatched
        }


        list.forEachIndexed { index, history ->

            if (id!=null && id == history.id) {
                history.isWatched = true
            }


        }

newList = list
        return list
    }
}