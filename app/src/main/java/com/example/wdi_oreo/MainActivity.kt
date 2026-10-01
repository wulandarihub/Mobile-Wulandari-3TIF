package com.example.wdi_oreo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wdi_oreo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Berpindah ke SnackActivity saat tombol diklik
        binding.btnMyProject.setOnClickListener {
            val intent = Intent(this, SnackActivity::class.java)
            startActivity(intent)
        }
    }
}