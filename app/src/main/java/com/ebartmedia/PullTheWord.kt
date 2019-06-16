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
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.widget.Toast
import com.ebartmedia.Database.WordRepository
import com.ebartmedia.Local.WordDAO
import com.ebartmedia.Local.WordDataSource
import com.ebartmedia.Local.WordDatabase
import com.ebartmedia.Model.Word
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.content_add_word.*
import kotlinx.android.synthetic.main.content_pull_the_word.*

class PullTheWord : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var compositeDisposable: CompositeDisposable?=null
    private var wordRepository: WordRepository?=null
    private var wordDAO: WordDAO?=null

    var count: Int?=null

    var count1: Int = 0

    var randomword: Int = 0
    var pl:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_the_word)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        compositeDisposable = CompositeDisposable()

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

        val wordDatabase = WordDatabase.getInstance(this)
        wordRepository = WordRepository.getInstance(WordDataSource.getInstance(wordDatabase.wordDAO()))


        buttonPullTheWord.setOnClickListener({



           // count = wordRepository!!.getCount();


         //   textPullTheWord.setText("lkjsdflkjsdflkjsdflj")
           // Log.d("count", "count" + count);


            val disposable = Observable.create(ObservableOnSubscribe<Any> { e->

                val word = Word()
                //  word.engword = "lkajsdf"
                //  word.plword = "lkjsdf"

         //       word.engword = eng
         //       word.plword = pl

                //  wordRepository!!.getCount()
                //       Log.d("getCount","getCount" + count)


                //    count = wordRepository!!.getCount()

                //  count = wordDAO.getCount()

                count = wordRepository!!.getCount()

                Log.d("count", "ount" + count)

                count1 = count as Int

                randomword = wordRepository!!.makeRand(count1)

              //  pl = wordRepository!!.getPLWord(count1)
                pl = wordRepository!!.getPLWord(randomword)

                Log.d("randomword", "randomword" + pl)

               // textPullTheWord.setText(randomword.toString())
                textPullTheWord.setText(pl)

              pl = wordRepository!!.getPLWord(count1)

                Log.d("pl", "pl" + pl)




              //  wordRepository!!.insertWord(word)
                e.onComplete()

            })

                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(io.reactivex.functions.Consumer {

                },

                    io.reactivex.functions.Consumer {

                            throwable-> Toast.makeText(this, ""+throwable.message, Toast.LENGTH_SHORT).show()
                    },

                    Action {  } )

            compositeDisposable!!.addAll(disposable)









       // })










        })

    }

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
        menuInflater.inflate(R.menu.pull_the_word, menu)
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
}
