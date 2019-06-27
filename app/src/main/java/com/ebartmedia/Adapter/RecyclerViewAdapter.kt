package com.ebartmedia.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.ebartmedia.Model.Word
import com.ebartmedia.Model.Words
//import com.ebartmedia.Model.Words
import com.ebartmedia.R
import kotlinx.android.synthetic.main.word_item.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.WordItemViewHolder>() {
//class RecyclerViewAdapter(internal var context: Context, internal var words: ArrayList<Word> ) : RecyclerView.Adapter<com.ebartmedia.Adapter.RecyclerViewAdapter.WordItemViewHolder>(), Filterable {


//    internal var filterListResult: ArrayList<Word>
//
//    init {
//        this.filterListResult = words
//    }
//
//    override fun getFilter(): Filter {
//
//        return object: Filter() {
//            override fun performFiltering(charString: CharSequence?): FilterResults {
//
//                val charSearch = charString.toString()
//                if (charSearch.isEmpty()) {
//
//                    filterListResult = words
//                } else {
//
//                    val resultLst = ArrayList<Word>()
//
//                    for (row in words) {
//
//                        if(row.engword!!.toLowerCase()?.contains(charSearch.toLowerCase()))
//                            resultLst.add(row)
//                    }
//                    filterListResult = resultLst
//
//                }
//                val filterResults = Filter.FilterResults()
//                filterResults.values = filterListResult
//                return filterResults
//            }
//
//            override fun publishResults(charSquence: CharSequence?, filterResults: FilterResults?) {
//
//                filterListResult = filterResults?.values as ArrayList<Word>
//                notifyDataSetChanged()
//            }
//
//
//        }
//    }

    private val data: MutableList<Word> = mutableListOf()

   //  val data = ArrayList<Word>()
   // val data = ArrayList<Words>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): WordItemViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.word_item, parent, false)

        return WordItemViewHolder(view)

    }

    override fun getItemCount(): Int {

      //  return filterListResult.size

        return data.size

    }

    override fun onBindViewHolder(viewHolder: WordItemViewHolder, position: Int) {

//        viewHolder.repoEngword.text = data[position].engword
//        viewHolder.repoPlword.text = data[position].plword


        viewHolder.binModel(data[position])


      //  viewHolder.repoPlword.text = filterListResult[position].engword
      //  viewHolder.repoPlword.text = filterListResult[position].plword
    }

 //   public fun addWord(word: ArrayList<Word>) {
 public fun addWord(word: List<Word>) {

        data.addAll(word)
        notifyDataSetChanged()

    }

    inner class WordItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val repoEngword = view.engword
        val repoPlword = view.plword


        fun binModel(data : Word) {

            repoEngword.text = data.engword
            repoPlword.text = data.plword

        }

    }


}