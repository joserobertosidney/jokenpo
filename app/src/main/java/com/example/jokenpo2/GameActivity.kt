package com.example.jokenpo2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.jokenpo2.databinding.ActivityGameBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class GameActivity : AppCompatActivity(){

    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav : BottomNavigationView
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var editText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("lifeCycle","onCreate")

        val binding = ActivityGameBinding.inflate(layoutInflater)
        val toolbar = binding.toolbarSecondActivity


        setContentView(binding.root)
        setSupportActionBar(toolbar)

        drawer = binding.root
        navDrawer = binding.navView
        bottomNav = binding.bottomNav
        editText = binding.editTextTextPersonName

        savedInstanceState?.getString("editTextValue")?.let {
            editText.setText(it)
        }



        val navHostFragment= supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController =  navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(setOf(R.id.resultFragment, R.id.playerFragment), drawer)

        navController.addOnDestinationChangedListener {_, destination,_ ->
            when (destination.id){
                R.id.homeFragment -> bottomNav.visibility = View.GONE
                else ->bottomNav.visibility = View.VISIBLE
            }
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        navDrawer.setupWithNavController(navController)
        bottomNav.setupWithNavController(navController)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("editTextValue",editText.text.toString())

    }

    override fun onResume() {
        super.onResume()
        Log.d("lyfeCycle","onResume")

    }

    override fun onStop() {
        super.onStop()

        Log.d("lyfeCycle","onStop")

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("lyfeCycle","onDestroy")
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }

}