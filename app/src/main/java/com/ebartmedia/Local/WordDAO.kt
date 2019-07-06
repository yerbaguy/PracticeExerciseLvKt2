package com.ebartmedia.Local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.ebartmedia.Model.Word
import com.ebartmedia.Model.Words
import io.reactivex.Flowable


@Dao
interface WordDAO {

   // @get:Query("SELECT * FROM word")
    @get:Query("SELECT id, engword FROM word")
    val allWords: Flowable<List<Word>>
  //  val allWords: Flowable<ArrayList<Word>>

    @get:Query("SELECT id, engword FROM word")
    val selectAllWords: List<Word>


    @Insert
    fun insertWord(vararg words: Word)

//    @Query("SELECT COUNT(id) FROM Word")
//    fun getCount()
    @Query("SELECT COUNT(id) FROM word")
    fun getCount(): Int
    @Query("SELECT plword FROM Word WHERE id LIKE :count ")
    fun getPlWord(count:Int): String

 //   fun makeRand(to: Int): Int

   // @Query("SELECT * FROM hamster WHERE name LIKE :search")


}