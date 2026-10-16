package com.example.wdi_oreo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wdi_oreo.databinding.ActivitySnackBinding

class SnackActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySnackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySnackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Jadikan toolbar sebagai ActionBar
        setSupportActionBar(binding.toolbarSnack)

        // 2. Aksi tombol kembali (Back Arrow) pada Toolbar
        binding.toolbarSnack.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}