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
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Menu
import com.ebartmedia.Adapter.RecyclerViewAdapter
import com.ebartmedia.Model.Word
import com.ebartmedia.Model.Words
import kotlinx.android.synthetic.main.content_show_word.*

class ShowWords : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


  //  val word = ArrayList<Words>()
    val word = ArrayList<Word>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_words)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)




//        val linearLayoutmg = LinearLayoutManager(applicationContext)
//        wordsList.layoutManager = linearLayoutmg
//
//        val wordRepo = RecyclerViewAdapter()



//        word.add(Words("kind", "rodzaj"))
//        word.add(Words("hardly", "ledwo"))
//        word.add(Words("least", "najmniej"))
//        word.add(Words("particular", "szczegolny"))
//        word.add(Words("each", "kazdy"))
//        word.add(Words("case", "przypadek"))
//        word.add(Words("several", "kilka"))



 //       wordRepo.addWord(word)



        val wordRepo = RecyclerViewAdapter()
      //  val wordRepo = RecyclerViewAdapter(this, word)
        wordsList.layoutManager = LinearLayoutManager(this)
       // wordsList.adapter = wordRepo.addWord(word)




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
        menuInflater.inflate(R.menu.show_words, menu)
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
}
