package com.ebartmedia.Model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

//import android.support.annotation.NonNull
//import io.reactivex.annotations.NonNull


@Entity(tableName = "word")
class Word {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
  //  var id:Int? = null
    var id:Int = 0

    @ColumnInfo(name = "engword")
    var engword:String? = null
 //    engword:String?

    @ColumnInfo(name = "plword")
    var plword:String? = null
  //  plword:String? = null



}