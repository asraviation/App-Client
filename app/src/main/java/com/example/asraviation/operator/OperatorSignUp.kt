package com.example.asraviation.operator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.asraviation.R
import com.example.asraviation.databinding.ActivityOperatorSignUpBinding

class OperatorSignUp : AppCompatActivity() {
    private val binding:ActivityOperatorSignUpBinding by lazy{
        ActivityOperatorSignUpBinding.inflate(layoutInflater)
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

        binding.btnsubmit.setOnClickListener {
            val name=binding.edtopname.text.toString()
            val cname=binding.edtopcomapny.text.toString()
            val email=binding.edtopemail.text.toString()
            val number=binding.edtconumber.text.toString()
            val pass=binding.edtpass.text.toString()
            val copass=binding.edtcpass.text.toString()

            if(name.isEmpty() || cname.isEmpty() || email.isEmpty() || number.isEmpty() || pass.isEmpty() || copass.isEmpty()) {
                Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show()
            }
            else{
                if(pass!=copass) {
                    Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show()
                }
                else{
                    startActivity(Intent(this,OperatorMainPage::class.java))
                    finish()
                }
            }
        }

        binding.btngooglelogin.setOnClickListener {
            Toast.makeText(this, "Google login", Toast.LENGTH_SHORT).show()
        }

        binding.txtsignin.setOnClickListener {
            startActivity(Intent(this,OperatorLogin::class.java))
            finish()
        }

    }
}