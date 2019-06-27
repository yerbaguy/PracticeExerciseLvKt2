package com.ebartmedia.Database

import android.arch.lifecycle.LiveData
import com.ebartmedia.Model.Word
import com.ebartmedia.Model.Words
import io.reactivex.Flowable
import java.util.*

class WordRepository(private val mLocationDataSource: IWordDataSource):IWordDataSource {
    override val allWords: Flowable<List<Word>>
  //  override val allWords: Flowable<ArrayList<Word>>
  //  override val allWords: Flowable<List<Words>>
        get() = mLocationDataSource.allWords



//    override fun selectAllWords(): LiveData<List<Word>> {
//
//        return mLocationDataSource.selectAllWords()
//    }

//    override fun makeRand(to: Int): Int {
//
//        val from = 1
//
//        val random = Random()
//
//        return random.nextInt(to - from) + from
//
//    }


       fun makeRand(to: Int): Int {

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