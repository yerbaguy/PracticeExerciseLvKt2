package com.ebartmedia

import android.app.SearchManager
import android.content.Context
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
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.widget.Toast
import com.ebartmedia.Adapter.RecyclerViewAdapter
import com.ebartmedia.Database.WordRepository
import com.ebartmedia.Local.WordDataSource
import com.ebartmedia.Local.WordDatabase
import com.ebartmedia.Model.Word
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.content_showw_word.*

class ShowwWord : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

        lateinit var adapter: RecyclerViewAdapter
        var compositeDisposable: CompositeDisposable?=null


        var word: MutableList<Word> = ArrayList<Word>()
        var searchView: SearchView?=null

        private var wordRepository: WordRepository? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showw_word)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this)

        compositeDisposable = CompositeDisposable()

        adapter = RecyclerViewAdapter(this, word)

        recycler_view.adapter = adapter



        val wordDatabase = WordDatabase.getInstance(this)
        wordRepository = WordRepository.getInstance(WordDataSource.getInstance(wordDatabase.wordDAO()))




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

        loadData()
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

        if (!searchView!!.isIconified) {

            searchView!!.isIconified = true
            return
        }

        super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.showw_word, menu)

        val searchManager:SearchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager

      //  searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView = menu!!.findItem(R.id.menu_search).actionView as SearchView
        searchView!!.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView!!.maxWidth = Int.MAX_VALUE


        searchView!!.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {

                adapter.filter.filter(p0)
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                adapter.filter.filter(p0)
                return false
            }


        })


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        val id = item!!.itemId

        return if(id == R.id.action_search) {
            true
        } else super.onOptionsItemSelected(item)



//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
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

                var intent = Intent(this, ShowwWord::class.java)

                startActivity(intent)
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

//        compositeDisposable!!.add(wordRepository!!.allWords
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe { allwords ->
//                displayData(allwords as ArrayList<Word>) } )
//
//                    }


        val disposable = wordRepository!!.allWords
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {

                    // words -> words.toString()

                    //   allWords -> onGetAllWords(allWords)





                        allwords ->
                  //  onGetAllWords(words)
                    displayData(allwords)
                    //  Log.d("allwords", "allwords" + allWords)

                    //   words -> onGetAllWords(word)
                    // adapter.addWord(word)

                    // adapter.addWord(word)


                })
            {

                    throwable ->
                Toast.makeText(this, "" + throwable.message, Toast.LENGTH_SHORT).show()
            }

        compositeDisposable!!.addAll(disposable)







    }

    private fun displayData(allwords: List<Word>) {

        word.clear()

        word.addAll(allwords)

        adapter.notifyDataSetChanged()

    }

    override fun onStop() {

        super.onStop()
        compositeDisposable?.clear()
    }


}
