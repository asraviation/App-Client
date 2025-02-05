package com.example.asraviation.operator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.asraviation.LoginPage
import com.example.asraviation.R
import com.example.asraviation.databinding.ActivityOperatorLoginBinding

class OperatorLogin : AppCompatActivity() {
    private val binding:ActivityOperatorLoginBinding by lazy{
        ActivityOperatorLoginBinding.inflate(layoutInflater)
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

        binding.btnlogin.setOnClickListener {
            val name=binding.edtname.text.toString()
            val pass=binding.edtpassword.text.toString()
            if(name.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Please Enter All Details", Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(Intent(this,OperatorMainPage::class.java))
                finish()
            }
        }

        binding.btnuserlogin.setOnClickListener {
            startActivity(Intent(this,LoginPage::class.java))
            finish()
        }

        binding.txtsignup.setOnClickListener {
            startActivity(Intent(this,OperatorSignUp::class.java))
            finish()
        }

        binding.btngooglelogin.setOnClickListener {
            Toast.makeText(this, "Google Btn Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}