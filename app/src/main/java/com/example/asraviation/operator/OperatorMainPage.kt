package com.example.asraviation.operator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.asraviation.Home_Client_Frag
import com.example.asraviation.R
import com.example.asraviation.databinding.ActivityOperatorMainPageBinding
import com.example.asraviation.databinding.FragmentFragOperatorProfileBinding

class OperatorMainPage : AppCompatActivity() {
    private val binding:ActivityOperatorMainPageBinding by lazy{
        ActivityOperatorMainPageBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Set default fragment as Home
        if (savedInstanceState == null) {
            replaceFragment(FragOperatorHome())
        }

        // Set Home as the selected tab by default
        binding.opbottomnav1.selectedItemId = R.id.ophomebottom

        // Handle bottom navigation item clicks
        binding.opbottomnav1.setOnItemSelectedListener {
            when (it.itemId) {
              R.id.ophomebottom -> replaceFragment(FragOperatorHome())
              R.id.opanalyticsbottom -> replaceFragment(FragOperatorAnallytics())
              R.id.opbookingbottom -> replaceFragment(FragOperatorBooking())
                R.id.opprofilebottom -> replaceFragment(FragOperatorProfile())
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