package com.example.asraviation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.asraviation.databinding.ActivitySignUpPageBinding

class SignUpPage : AppCompatActivity() {
    private val binding:ActivitySignUpPageBinding by lazy{
        ActivitySignUpPageBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnsignup.setOnClickListener {
            val email=binding.edtemail.text.toString()
            val contact=binding.edtcontact.text.toString()
            val username=binding.edtuser.text.toString()
            val pass=binding.edtpass.text.toString()
            val cpass=binding.edtcpass.text.toString()

            if(email.isEmpty() || contact.isEmpty() || username.isEmpty() || pass.isEmpty() || cpass.isEmpty()) {
                Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Sign Up btn Clicked", Toast.LENGTH_SHORT).show()
            }

        }

        binding.btngooglelogin.setOnClickListener {
            Toast.makeText(this, "Google btn clicked", Toast.LENGTH_SHORT).show()
        }

        binding.txtsignin.setOnClickListener {
            startActivity(Intent(this,LoginPage::class.java))
            finish()
        }


    }
}