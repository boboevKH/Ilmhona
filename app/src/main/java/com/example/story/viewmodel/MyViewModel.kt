package com.example.story.viewmodel

import com.example.story.model.History
import com.example.story.R

class MyViewModel {

    private var newList: List<History> = listOf()

    fun getNewData(id: Int? = null) : MutableList<History> {
        var list = mutableListOf(
            History(1,(R.drawable.ic_launcher_background)),
            History(2,(R.drawable.ic_launcher_background)),
            History(3,(R.drawable.ic_launcher_background)),
            History(4, (R.drawable.ic_launcher_background)),
            History(5, (R.drawable.ic_launcher_background)),
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