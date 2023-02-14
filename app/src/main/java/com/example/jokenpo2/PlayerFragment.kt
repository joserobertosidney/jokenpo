package com.example.jokenpo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.media.MediaBrowserService.BrowserRoot
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.jokenpo2.databinding.FragmentPlayerBinding
import com.google.android.material.navigation.NavigationView

class PlayerFragment : Fragment() {
    lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentPlayerBinding.inflate(inflater,container,false)
        root = binding.root

        setHasOptionsMenu(true)

        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.second_screen_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController())
    }

    }
