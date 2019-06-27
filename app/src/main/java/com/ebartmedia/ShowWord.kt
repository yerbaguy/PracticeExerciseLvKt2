package com.ebartmedia

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.*
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.widget.ArrayAdapter
import android.widget.Toast
import com.ebartmedia.Adapter.RecyclerViewAdapter
import com.ebartmedia.Database.WordRepository
import com.ebartmedia.Local.WordDataSource
import com.ebartmedia.Local.WordDatabase
import com.ebartmedia.Model.Word
import com.ebartmedia.Model.Words
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.content_show_word.*
import kotlinx.android.synthetic.main.word_item.view.*

class ShowWord : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


  //  val word = ArrayList<Word>()
    val word = ArrayList<Word>()
  //  val word = ArrayList<Words>()
    val displayList = ArrayList<Word>()
  //  val displayList = ArrayList<Words>()

    var eng:String?=""

    private lateinit var adapter: RecyclerViewAdapter

 //   lateinit var adapter: ArrayAdapter<*>
 //   var wordList:MutableList<Word> = ArrayList()


    private var compositeDisposable: CompositeDisposable?=null
    private var wordRepository: WordRepository?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_word)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        adapter = RecyclerViewAdapter()
     //   adapter = RecyclerViewAdapter(this, word)
        wordsList.adapter = adapter


        val linearLayoutmg = LinearLayoutManager(applicationContext)
        wordsList.layoutManager = linearLayoutmg
      //  wordsList.layoutManager = RecyclerViewAdapter(displayList, this)

        val wordRepo = RecyclerViewAdapter()
      //  val wordRepo = RecyclerViewAdapter(this, word)

//        val words = Word()
//        words.engword="kind"
//        words.plword="rodzaj"
//        words.engword="hardly"
//        words.plword="ledwo"
//        words.engword="particular"
//        words.plword="szczegolny"
//        words.engword="each"
//        words.plword="kazdy"
//        words.engword="case"
//        words.plword="przypadek"
//        words.engword="several"
//        words.plword="kilkanascie"


//        word.add(Words("kind", "rodzaj"))
//        word.add(Words("hardly", "ledwo"))
//        word.add(Words("least", "najmniej"))
//        word.add(Words("particular", "szczegolny"))
//        word.add(Words("each", "kazdy"))
//        word.add(Words("case", "przypadek"))
//        word.add(Words("several", "kilka"))



//        word.add(Word("kind", "rodzaj"))
//        word.add(Word("hardly", "ledwo"))
//        word.add(Word("least", "najmniej"))
//        word.add(Word("particular", "szczegolny"))
//        word.add(Word("each", "kazdy"))
//        word.add(Word("case", "przypadek"))
//        word.add(Word("several", "kilka"))





        // word.add(words)

         //  word.addAll(listOf(Word()))

     //   wordRepo.addWord(word)

      //  wordRepo.addWord(word)





        compositeDisposable = CompositeDisposable()

//        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, wordList)
//        registerForContextMenu(lst_users)
//
//        lst_users!!.adapter = adapter



        val wordDatabase = WordDatabase.getInstance(this)
        wordRepository = WordRepository.getInstance(WordDataSource.getInstance(wordDatabase.wordDAO()))



        loadData()

//        val words_list = findViewById<RecyclerView>(R.id.recycler_view) as RecyclerView
//
//        words_list.layoutManager = LinearLayoutManager(this)

      //  words_list.layoutManager = GridLayoutManager(this)

//        val linearLayoutmg = LinearLayoutManager(applicationContext)
//        recycler_view.layoutManager = linearLayoutmg


      //  val recyclerViewAdapter = RecyclerViewAdapter()

            // recyclerViewAdapter.addWord(new Word("lkjasdf", "lkjasdflkj"))


//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
      //  val adapter = RecyclerViewAdapter()
//        val adapter = RecyclerViewAdapter(this, word)  //here
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = RecyclerView.LayoutManager(RecyclerVi)



        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }



//    private fun loadData() {
//
//        val disposable = wordRepository!!.allWords
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe( { words -> onGetAllWords(words) } )
//            {
//
//                throwable -> Toast.makeText(this, "" + throwable.message, Toast.LENGTH_SHORT).show()
//            }
//
//        compositeDisposable!!.add(disposable)
//
//            }
//    //)
//    }
//
//    private fun onGetAllWords(words: List<Word>) {
//
//        wordList.clear()
//        wordList.addAll(words)
//        adapter.notifyDataSetChanged()
//
//    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  menuInflater.inflate(R.menu.show_word, menu)

        menuInflater.inflate(R.menu.main_, menu)


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {

            R.id.addword -> {

                val intent = Intent(this, AddWord::class.java)

                startActivity(intent)

            }

            R.id.pulltheword -> {

                val intent = Intent(this, PullTheWord::class.java)

                startActivity(intent)

            }

            R.id.showword -> {

//                var intent = Intent(this, ShowWord::class.java)
//
//                startActivity(intent)
            }


            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }



        private fun loadData() {

        val disposable = wordRepository!!.allWords
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({

                   // words -> words.toString()

               //   allWords -> onGetAllWords(allWords)

                words -> onGetAllWords(words)
              //  Log.d("allwords", "allwords" + allWords)

                 //   words -> onGetAllWords(word)
                   // adapter.addWord(word)

              //  adapter.addWord(word)



            })
            {

                throwable->Toast.makeText(this, "" + throwable.message, Toast.LENGTH_SHORT).show()
            }

            compositeDisposable!!.addAll(disposable)

    }

  //  private fun onGetAllWords(words: List<Words>) {
  private fun onGetAllWords(allWords: List<Word>) {


      Log.d("onGetAllWords", "onGetAllWords" + allWords)

        word.clear()
       // word.addAll(words)
      //  word.addAll(allWords)
       adapter.addWord(allWords)
        adapter.notifyDataSetChanged()


      //  words.toString()

      //  eng = words.get(1).engword

        Log.d("eng", "eng" + eng)


//         wordList.clear()
//         wordList.addAll(words)
//
//        Log.d("words", "words" + words)
//         adapter.notifyDataSetChanged()

    }
}
