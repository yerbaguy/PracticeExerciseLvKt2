package com.ebartmedia.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import com.ebartmedia.Model.Word
import com.ebartmedia.Model.Words
//import com.ebartmedia.Model.Words
import com.ebartmedia.R
import kotlinx.android.synthetic.main.word_item.view.*
import org.w3c.dom.Text

//class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.WordItemViewHolder>() {
//class RecyclerViewAdapter(internal val context: Context, private var words: List<Word>) : RecyclerView.Adapter<RecyclerViewAdapter.WordItemViewHolder>() {
class RecyclerViewAdapter(internal var context: Context, internal var word: List<Word> ) : RecyclerView.Adapter<com.ebartmedia.Adapter.RecyclerViewAdapter.WordItemViewHolder>(), Filterable {


   //   internal var filterListWord: List<Word>
    internal var filterListWord: List<Word>

    init {

        this.filterListWord = word
    }


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): WordItemViewHolder {
        val itemView  = LayoutInflater.from(parent.context).inflate(R.layout.word_item, parent, false )

        return WordItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {

        return filterListWord.size

    }

    override fun onBindViewHolder(holder: WordItemViewHolder, position: Int) {

        holder.engw.text = filterListWord[position].engword
        holder.plw.text = filterListWord[position].plword

    }

    override fun getFilter(): Filter {

        return object: Filter() {
            override fun performFiltering(charString: CharSequence?): FilterResults {

                val charSearch:String = charString.toString()

                if(charSearch.isEmpty()) {

                    filterListWord = word
                } else {

                    val resultList = ArrayList<Word>()

                    for (row in word) {

                        if (row.engword!!.toLowerCase().contains(charSearch.toLowerCase()))
                            resultList.add(row)
                    }

                    filterListWord = resultList
                }

                val filterResults:FilterResults = Filter.FilterResults()
                filterResults.values = filterResults

                return filterResults

            }

            override fun publishResults(charSquence: CharSequence?, filterResults: FilterResults?) {

              //  filterListWord = filterResults!!.values as ArrayList<Word>
              //  filterListWord = filterResults!!.values as List<Word>
             //   filterListWord = filterResults?.values as List<Word>


                notifyDataSetChanged()

            }


        }

    }


    class WordItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        internal var engw:TextView
        internal var plw:TextView

        init {
            engw = itemView.findViewById(R.id.engword)
            plw = itemView.findViewById(R.id.plword)
        }


    }
}
