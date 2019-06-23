package com.ebartmedia.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebartmedia.Model.Word
import com.ebartmedia.Model.Words
import com.ebartmedia.R
import kotlinx.android.synthetic.main.word_item.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.WordItemViewHolder>() {

   // val data = ArrayList<Word>()
    val data = ArrayList<Words>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): WordItemViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.word_item, parent, false)

        return WordItemViewHolder(view)

    }

    override fun getItemCount(): Int {

        return data.size

    }

    override fun onBindViewHolder(viewHolder: WordItemViewHolder, position: Int) {

        viewHolder.repoEngword.text = data[position].engword
        viewHolder.repoPlword.text = data[position].plword
    }

    public fun addWord(word: ArrayList<Words>) {

        data.addAll(word)
        notifyDataSetChanged()

    }

    class WordItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val repoEngword = view.engword
        val repoPlword = view.plword


    }
}