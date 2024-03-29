package com.ebartmedia.Database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Query
import com.ebartmedia.Model.Word
import com.ebartmedia.Model.Words
import io.reactivex.Flowable

interface IWordDataSource {

     fun insertWord(vararg word: Word)

  //  @Query("SELECT COUNT(id) FROM word")
    fun getCount(): Int

  //  @Query("SELECT plword FROM word WHERE id LIKE :count")
    fun getPLWord(count:Int): String

//    @Query("SELECT * FROM word")
//    fun selectAllWords(): LiveData<List<Word>>

  @Query("SELECT * FROM word")
  fun selectAllWords(): List<Word>



  val allWords: Flowable<List<Word>>
 // val allWords: Flowable<ArrayList<Word>>
  //  val allWords: Flowable<List<Words>>

   // fun makeRand(to:Int): Int
}