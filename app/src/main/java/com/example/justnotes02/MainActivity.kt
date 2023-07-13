package com.example.justnotes02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import com.example.justnotes02.databinding.ActivityMainBinding
import com.example.justnotes02.utils.APP_ACTIVITY

//
class MainActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var navController: NavController
    private var _binding: ActivityMainBinding? = null
    val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbar = binding.toolbar
        APP_ACTIVITY = this
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setSupportActionBar(toolbar)
        toolbar.title = getString(R.string.title)


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}