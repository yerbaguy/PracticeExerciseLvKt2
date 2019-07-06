package com.ebartmedia

import android.arch.lifecycle.ViewModel
import com.ebartmedia.Model.Word
import io.reactivex.Completable

class MainViewModel : ViewModel() {

       private val originalPosts: MutableList<Word> = mutableListOf()

    val filteredPosts: MutableList<Word> = mutableListOf()
    val oldFilteredPosts: MutableList<Word> = mutableListOf()

    init {

        oldFilteredPosts.addAll(originalPosts)
    }



    fun search(query: String): Completable = Completable.create {

        val wanted = originalPosts.filter {

            it.engword!!.contains(query) || it.plword!!.contains(query)
        }.toList()

        filteredPosts.clear()
        filteredPosts.addAll(wanted)
        it.onComplete()

    }

}