package com.ebartmedia.Local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.ebartmedia.Model.Word


@Dao
interface WordDAO {


    @Insert
    fun insertWord(vararg words: Word)

//    @Query("SELECT COUNT(id) FROM Word")
//    fun getCount()
    @Query("SELECT COUNT(id) FROM word")
    fun getCount(): Int

}