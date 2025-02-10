package com.example.asraviation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.asraviation.databinding.ActivityClientPageBinding

class Client_Page : AppCompatActivity() {
    private val binding:ActivityClientPageBinding by lazy{
        ActivityClientPageBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        // Set default fragment as Home
        if (savedInstanceState == null) {
            replaceFragment(Home_Client_Frag())
        }

        // Set Home as the selected tab by default
        binding.bottomnav1.selectedItemId = R.id.homebottom

        // Handle bottom navigation item clicks
        binding.bottomnav1.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homebottom -> replaceFragment(Home_Client_Frag())
                R.id.historybottom -> replaceFragment(Booking_Client_Frag())
                R.id.fleetbottom -> replaceFragment(FleetClientFrag())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fr_lay, fragment)
            .commit()
    }
}