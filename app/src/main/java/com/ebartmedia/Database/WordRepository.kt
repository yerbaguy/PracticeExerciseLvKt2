package com.ebartmedia.Database

import com.ebartmedia.Model.Word
import java.util.*

class WordRepository(private val mLocationDataSource: IWordDataSource):IWordDataSource {
    override fun makeRand(to: Int): Int {

        val from = 1

        val random = Random()

        return random.nextInt(to - from) + from

    }

    override fun getPLWord(count: Int): String {

        return mLocationDataSource.getPLWord(count)
    }

    override fun getCount(): Int {

        return mLocationDataSource.getCount()
    }
//    override fun getCount() {
//
//        return mLocationDataSource.getCount()
//    }

   // val count:Unit = mLocationDataSource.getCount()



    override fun insertWord(vararg word: Word) {

        mLocationDataSource.insertWord(*word)

    }


    companion object {

        private var mInstance:WordRepository?=null

        fun getInstance(mLocationDataSource: IWordDataSource):WordRepository {

            if (mInstance == null)

                mInstance = WordRepository(mLocationDataSource)

            return mInstance!!
        }
    }
}