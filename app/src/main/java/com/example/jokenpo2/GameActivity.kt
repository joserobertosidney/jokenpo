package com.example.jokenpo2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
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

class GameActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{

    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav : BottomNavigationView
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var editText: EditText
    var currentPlay: String  = "Papel"



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

        bottomNav.setupWithNavController(navController)
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.resultFragment ->{
                    val args = Bundle()
                    args.putString("currentPlay", currentPlay)
                    navController.navigate(it.itemId, args)
                }
                else -> navController.navigate(it.itemId)
            }
            true
        }

        navDrawer.setupWithNavController(navController)
        navDrawer.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.resultFragment ->{
                    val args = Bundle()
                    args.putString("currentPlay", currentPlay)
                    navController.navigate(it.itemId, args)
                }
                else -> navController.navigate(it.itemId)
            }
            true
        }



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

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val avaiablePlay = resources.getStringArray(R.array.available_plays_array)
        currentPlay = avaiablePlay[position]

        Toast.makeText(this, "Jogada Selecionada :$currentPlay", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

}