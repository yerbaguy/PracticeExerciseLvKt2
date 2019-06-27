package com.ebartmedia.Local

import android.arch.lifecycle.LiveData
import com.ebartmedia.Database.IWordDataSource
import com.ebartmedia.Model.Word
import com.ebartmedia.Model.Words
import io.reactivex.Flowable
import java.lang.reflect.Array.get


class WordDataSource(private val wordDAO: WordDAO): IWordDataSource {
    override val allWords: Flowable<List<Word>>
 //   override val allWords: Flowable<ArrayList<Word>>
 //   override val allWords: Flowable<List<Words>>
        get() = wordDAO.allWords

    override fun insertWord(vararg word: Word) {

        wordDAO.insertWord(*word)
    }

    override fun getCount(): Int {

        return wordDAO.getCount()

    }
//
//
//    override fun getPLWord(count: Int): String {
//
//        return wordDAO.getPlWord(count)
//    }
//
//    override fun makeRand(to: Int): Int {
//
//        return wordDAO.makeRand(to)
//    }



//    override fun makeRand(to: Int): Int {
//
//        return wordDAO.getCount()
//    }

    override fun getPLWord(count: Int): String {

        return wordDAO.getPlWord(count)
    }


//    override fun getCount() {
//
//        wordDAO.getCount()
//    }

//    override fun insertWord(vararg word: Word) {
//
//
//
//        wordDAO.insertWord(*word )
//    }


    companion object {

        private var mInstance:WordDataSource?=null

        fun getInstance(wordDAO: WordDAO):WordDataSource {

            if (mInstance == null)

                mInstance = WordDataSource(wordDAO)

            return mInstance!!
        }
    }
}