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
import com.anant.codingguide.fragment.*


class ControlActivity : AppCompatActivity() {


    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView
    var previousMenuItem:MenuItem?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frame)
        navigationView = findViewById(R.id.navigationView)

        openHome()
        supportActionBar?.title="Home"


        setUpToolbar()

        val actionBarDrawerToggle=ActionBarDrawerToggle(this@ControlActivity,drawerLayout,R.string.open_drawer,R.string.close_drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {


            if(previousMenuItem != null){
                previousMenuItem?.isChecked=false
            }
            it.isCheckable=true
            it.isChecked=true
            previousMenuItem=it

            when(it.itemId)
            {
                R.id.home->{
                      openHome()
                    drawerLayout.closeDrawers()

                }

                R.id.language->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame,
                        LanguagesFragment()
                    ).commit()
                    supportActionBar?.title="Programming languages"
                    drawerLayout.closeDrawers()
                }

                R.id.dev->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame,
                        DevelopmentFragment()
                    ).commit()
                    supportActionBar?.title="Development"
                    drawerLayout.closeDrawers()
                }

                R.id.quest->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame,
                        CompetitiveProgrammingFragment()
                    ).commit()
                    supportActionBar?.title="Competitive programming"
                    drawerLayout.closeDrawers()
                }



                R.id.compiler->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame,
                        CompilerFragment()
                    ).commit()
                    supportActionBar?.title="Code Compiler"
                    drawerLayout.closeDrawers()
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
            //supportActionBar?.title="Toolbar Title"
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

   fun  openHome()
    {
        val fragment=HomeFragment()
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame,fragment)
        transaction.commit()
        supportActionBar?.title="Home"
        navigationView.setCheckedItem(R.id.home)
    }

    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frame)

        when(frag){
            !is HomeFragment -> openHome()

            else -> super.onBackPressed()
        }
    }



}


