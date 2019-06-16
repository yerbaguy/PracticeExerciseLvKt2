package com.ebartmedia.Database

import android.arch.persistence.room.Query
import com.ebartmedia.Model.Word

interface IWordDataSource {

    fun insertWord(vararg word: Word)

    @Query("SELECT COUNT(id) FROM word")
    fun getCount(): Int

    @Query("SELECT plword FROM word WHERE id LIKE :count")
    fun getPLWord(count:Int): String


    fun makeRand(to:Int): Int
}