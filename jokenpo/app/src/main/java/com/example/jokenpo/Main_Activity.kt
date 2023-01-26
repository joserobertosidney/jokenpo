package com.example.jokenpo

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jokenpo.databinding.ActivityMainBinding

class Main_Activity : AppCompatActivity (){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val segundaTelaIntent = Intent (this,SegundaTela ::class.java)


        binding.startActivity2Button.setOnClickListener{
            startActivity(segundaTelaIntent)
        }

    }



}