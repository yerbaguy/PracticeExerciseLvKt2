package com.ebartmedia

import android.support.v7.util.DiffUtil
import com.ebartmedia.Model.Word

class PostsDiffUtilCallback(private val oldList: List<Word>, private val newList: List<Word>) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true
}