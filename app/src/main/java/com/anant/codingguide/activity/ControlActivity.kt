package com.anant.codingguide.activity

//import android.widget.Toolbar
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.anant.codingguide.R


class ControlActivity : AppCompatActivity() {


    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frame)
        navigationView = findViewById(R.id.navigationView)

        setUpToolbar()

        val actionBarDrawerToggle=ActionBarDrawerToggle(this@ControlActivity,drawerLayout,R.string.open_drawer,R.string.close_drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {

            when(it.itemId)
            {
                R.id.home->{
                    Toast.makeText(applicationContext,"Home",Toast.LENGTH_LONG).show()
                }

                R.id.language->{
                    Toast.makeText(applicationContext,"Language",Toast.LENGTH_LONG).show()
                }

                R.id.dev->{
                    Toast.makeText(applicationContext,"Dev",Toast.LENGTH_LONG).show()
                }

                R.id.quest->{
                    Toast.makeText(applicationContext,"Quest",Toast.LENGTH_LONG).show()
                }

                R.id.inter->{
                    Toast.makeText(applicationContext,"Interview",Toast.LENGTH_LONG).show()
                }

                R.id.exit->{
                    Toast.makeText(applicationContext,"Exit",Toast.LENGTH_LONG).show()
                }
                

            }






            return@setNavigationItemSelectedListener true
        }

    }

    fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title="Toolbar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if(id==android.R.id.home)
        {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }



}


