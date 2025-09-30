package ru.justneedcoffee.thousandcourses.ui.main

import android.os.Bundle
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import ru.justneedcoffee.thousandcourses.R

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        window.decorView.getWindowInsetsController()
            ?.setSystemBarsAppearance(0, APPEARANCE_LIGHT_STATUS_BARS)

        setContentView(R.layout.activity_main)
//        navController = findNavController(R.id.navHostFragment)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}