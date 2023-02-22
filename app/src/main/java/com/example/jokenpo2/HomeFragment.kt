package com.example.jokenpo2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jokenpo2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    var name: String? = null
    lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        if (savedInstanceState?.containsKey("editTextValue") == true) {
            val value = savedInstanceState.getString("editTextValue")
            editText.setText(value)
        }

        Log.d("lyfeCycle", "onCreate")

        binding.buttonOfStart.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToGameNav()
            findNavController().navigate(action)
        }
        lifecycle.addObserver(CustomObserver2())

        return binding.root
    }
}

