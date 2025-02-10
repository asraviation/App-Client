package com.example.asraviation.operator

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.asraviation.R
import com.example.asraviation.databinding.ActivityOperatorAddFleetBinding

class OperatorAddFleet : AppCompatActivity() {
    private val binding:ActivityOperatorAddFleetBinding by lazy{
        ActivityOperatorAddFleetBinding.inflate(layoutInflater)
    }
    private lateinit var galleryLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize the gallery launcher
        galleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val selectedImageUri: Uri? = result.data?.data
                selectedImageUri?.let {
                    // Display the image in the ImageView (assuming addimg is an ImageView)
                    binding.addimg1.setImageURI(it)
                }
            }
        }

        binding.btnsubmit.setOnClickListener {
            val fnmae=binding.edtfleetname.text.toString()
            val hanger=binding.edthanger.text.toString()
            val location=binding.edtlocation.text.toString()
            val price=binding.slder.value.toString()
            val speed=binding.edtspeed.text.toString()
            val available=binding.switch1.isChecked.toString()
            binding.addimg.setOnClickListener{
                //add image from local storage from mobile
                openGallery()
            }

            if(fnmae.isEmpty() || hanger.isEmpty() || location.isEmpty() || price.isEmpty() || speed.isEmpty()){
                Toast.makeText(this, "Please Enter all the details", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Fleet added succsfully", Toast.LENGTH_SHORT).show()
                //timer to wait 2 sec
                Thread.sleep(2000)
                startActivity(Intent(this,FragOperatorFleet::class.java))
                finish()

            }
        }


    }


    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        galleryLauncher.launch(intent)
    }


}