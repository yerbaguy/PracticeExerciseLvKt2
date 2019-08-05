package com.ebartmedia.Adapter

import android.content.Context
import android.content.Intent
import android.support.design.widget.NavigationView
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.ebartmedia.*
import com.ebartmedia.Model.Word
//import com.ebartmedia.Model.Words

//class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.WordItemViewHolder>() {
//class RecyclerViewAdapter(internal val context: Context, private var words: List<Word>) : RecyclerView.Adapter<RecyclerViewAdapter.WordItemViewHolder>() {
class RecyclerViewAdapter(internal var context: Context, internal var word: List<Word> ) : RecyclerView.Adapter<com.ebartmedia.Adapter.RecyclerViewAdapter.WordItemViewHolder>(), Filterable {


   //   internal var filterListWord: List<Word>
    internal var filterListWord: List<Word>
    var mContext = context

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

        Log.d("onBindViewHolder", "onBindViewHolder" + holder)

        val en = holder.engw
        val p = holder.plw



        holder.setOnCustomItemClickListener(object :CustomItemClickListener {
            override fun onCustomItemClickListener(view: View, pos: Int) {

//                val intent = Intent(mContext, AddWord::class.java)

              //  startActivity(mContext, intent, pos)

              //  Toast.makeText(mContext, "lkajsdflkj", Toast.LENGTH_LONG).show()

              // view.context.startActivity<MainActivity>()
             //  startActivity(this@RecyclerViewAdapter, AddWord::class.java)


                var en = holder.engw.text.toString()
              //  var p = holder.engw.text.toString()

 //               val intent = Intent(view.context, WordDetails::class.java)
                val intent = Intent(view.context, Details::class.java)

                intent.putExtra("eng", en)
               // intent.putExtra("p", p)

                view.context.startActivity(intent)

            }


        })


//        holder.setOnCustomItemClickListener(object: CustomItemClickListener {
//            override fun onCustomItemClickListener(view: View, pos: Int) {
//
//               // Toast.makeText(mContext, "engw" + holder.engw.text + "plw" + holder.plw.text, Toast.LENGTH_LONG).show()
//
//
//
//            }
//
//        })

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


    class WordItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(v: View?) {

            this.customItemClickListener!!.onCustomItemClickListener(v!!, adapterPosition)


        }

        internal var engw:TextView
        internal var plw:TextView

        var customItemClickListener:CustomItemClickListener?=null

        init {
            engw = itemView.findViewById(R.id.engword)
            plw = itemView.findViewById(R.id.plword)

            itemView.setOnClickListener(this)






        }

        fun setOnCustomItemClickListener(itemClickListener:CustomItemClickListener) {

            this.customItemClickListener = itemClickListener
        }

//        override fun onClick(v: View?) {
//
//            this.customItemClickListener!!.onCustomItemClickListener(v!!, adapterPosition)
//        }

    }
}
