package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val navController by lazy {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHost) as NavHostFragment
        navHostFragment.navController
    }

    private val appToolbarConfig: AppBarConfiguration by lazy {
        val topLevelDestinations = setOf(
            R.id.onBoardingFragment,
            R.id.loginFragment,
            R.id.shoeListingFragment
        )
        AppBarConfiguration(topLevelDestinationIds = topLevelDestinations)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)


        setSupportActionBar(binding.toolbar)
        NavigationUI.setupActionBarWithNavController(
            this,
            navController,
            appToolbarConfig
        )
        Timber.plant(Timber.DebugTree())
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

}
