package com.ebartmedia.Local

import com.ebartmedia.Database.IWordDataSource
import com.ebartmedia.Model.Word


class WordDataSource(private val wordDAO: WordDAO): IWordDataSource {
    override fun getCount(): Int {

        return wordDAO.getCount()
    }
//    override fun getCount() {
//
//        wordDAO.getCount()
//    }

    override fun insertWord(vararg word: Word) {



        wordDAO.insertWord(*word )
    }


    companion object {

        private var mInstance:WordDataSource?=null

        fun getInstance(wordDAO: WordDAO):WordDataSource {

            if (mInstance == null)

                mInstance = WordDataSource(wordDAO)

            return mInstance!!
        }
    }
}