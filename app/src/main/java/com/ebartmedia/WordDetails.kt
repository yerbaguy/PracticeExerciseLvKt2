package com.ebartmedia

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity


class WordDetails : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_word_details)
    }
}