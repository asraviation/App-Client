package com.example.asraviation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.asraviation.databinding.ActivityLoginPageBinding
import com.example.asraviation.operator.OperatorLogin
import com.example.asraviation.operator.OperatorSignUp

class LoginPage : AppCompatActivity() {
    private val binding : ActivityLoginPageBinding by lazy{
        ActivityLoginPageBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //main login login
        binding.btnlogin.setOnClickListener {
            val username=binding.edtusername.text.toString()
            val password=binding.edtpassword.text.toString()
            if(username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please Enter All the Details", Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(Intent(this,Client_Page::class.java))
                finish()
            }
        }

        //google login button
        binding.btngooglelogin.setOnClickListener {
            Toast.makeText(this, "google Login Button clicked", Toast.LENGTH_SHORT).show()
        }

        //sign up logic
        binding.txtsignup.setOnClickListener {

            startActivity(Intent(this,SignUpPage::class.java))
            finish()
        }

        //operator login
        binding.btnoperatorlogin.setOnClickListener {
            startActivity(Intent(this,OperatorLogin::class.java))
            finish()
        }
    }
}