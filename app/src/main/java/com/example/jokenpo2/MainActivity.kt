package com.example.jokenpo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jokenpo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val toolbar = binding.toolbarFirstActivity

        setContentView(binding.root)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Jokenpô"
        supportActionBar?.setLogo(R.drawable.ic_logotipo)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val activity2Intent = Intent(this, GameActivity::class.java)

        binding.buttonOfStart.setOnClickListener{
            startActivity(activity2Intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}