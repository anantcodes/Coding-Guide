package com.anant.codingguide.activity


import android.content.DialogInterface
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.anant.codingguide.R
import com.anant.codingguide.fragment.*
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AlertDialog.Builder
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


class ControlActivity : AppCompatActivity() {


    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView
    var previousMenuItem: MenuItem? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frame)
        navigationView = findViewById(R.id.navigationView)

        openHome()
        supportActionBar?.title = "Home"


        setUpToolbar()

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@ControlActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {


            if (previousMenuItem != null) {
                previousMenuItem?.isChecked = false
            }
            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it


            when (it.itemId) {
                R.id.home -> {
                    openHome()
                    drawerLayout.closeDrawers()

                }

                R.id.language -> {
                    setUpFragment(LanguagesFragment())
                    supportActionBar?.title = "Programming languages"
                    drawerLayout.closeDrawers()
                }

                R.id.dev -> {
                    setUpFragment(DevelopmentFragment())
                    supportActionBar?.title = "Software Development"
                    drawerLayout.closeDrawers()
                }

                R.id.quest -> {
                    setUpFragment(CompetitiveProgrammingFragment())
                    supportActionBar?.title = "Competitive programming"
                    drawerLayout.closeDrawers()
                }


                R.id.compiler -> {
                    setUpFragment(CompilerFragment())
                    supportActionBar?.title = "Test your Code"
                    drawerLayout.closeDrawers()
                }


                R.id.exit -> {
                    val builder: android.app.AlertDialog.Builder =
                        android.app.AlertDialog.Builder(this@ControlActivity)
                    builder.setTitle(R.string.app_name)
                    builder.setIcon(R.mipmap.ic_launcher)
                    builder.setMessage("Do you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes",
                            DialogInterface.OnClickListener { dialog, id -> finish() })
                        .setNegativeButton("No",
                            DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
                    val alert: android.app.AlertDialog? = builder.create()
                    alert?.show()
                }


            }






            return@setNavigationItemSelectedListener true
        }

    }

    fun setUpToolbar() {
        setSupportActionBar(toolbar)
        //supportActionBar?.title="Toolbar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun setUpFragment(fragment: Fragment){
        val manager = supportFragmentManager.beginTransaction()
        manager.setCustomAnimations(
            R.anim.slide_in,
            R.anim.slide_out)

        manager.replace(
            R.id.frame,
            fragment
        )
        manager.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    fun openHome() {
        val fragment = HomeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
        supportActionBar?.title = "Home"
        navigationView.setCheckedItem(R.id.home)
    }

    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frame)

        when (frag) {
            !is HomeFragment -> openHome()

            else -> super.onBackPressed()
        }
    }


}


