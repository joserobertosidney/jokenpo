package com.example.jokenpo2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.jokenpo2.databinding.ActivityGameBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class GameActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawer: DrawerLayout
    lateinit var  navDrawer: NavigationView
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityGameBinding.inflate(layoutInflater)
        val toolbar = binding.toolbarSecondActivity

        setContentView(binding.root)
        setSupportActionBar(toolbar)

        drawer = binding.root
        navDrawer = binding.navView
        navDrawer.setNavigationItemSelectedListener(this)

        setupToolbar2()

        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, R.string.nav_open, R.string.nav_close)
        drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

    }

    private fun setupToolbar2(){

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.second_screen_menu,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
             return true
        }
        when (item.itemId){
            R.id.menu_settings -> {
                Snackbar.make(this,drawer,"Configurações",Snackbar.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_profile -> {
                Snackbar.make(this,drawer,"Perfil",Snackbar.LENGTH_SHORT).show()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){

            R.id.drawer_home -> {
                onBackPressed()
            }
        }
        drawer.closeDrawers()

        return true
    }

//    override fun onNvigationItemSelected (item: MenuItem): Boolean{
//        when (item.itemId){
//
//            R.id.menu_settings ->{
//                Snackbar.make(this,drawer,getString(R.string.menu_settings_title),Snackbar.LENGTH_SHORT).show()
//            }
//        }
//        drawer.closeDrawers()
//        return true
//    }
}