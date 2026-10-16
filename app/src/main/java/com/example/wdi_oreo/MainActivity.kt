package com.example.wdi_oreo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.wdi_oreo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Akses SharedPreferences "user_pref"
        val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)

        // Berpindah ke SnackActivity saat tombol diklik
        binding.btnMyProject.setOnClickListener {
            val intent = Intent(this, SnackActivity::class.java)
            startActivity(intent)
        }

        // Berpindah ke WebActivity saat tombol diklik
        binding.btnWebOreo.setOnClickListener {
            val intent = Intent(this, WebActivity::class.java)
            startActivity(intent)
        }

        // Berpindah ke ProfileActivity (Halaman Profil Developer)
        binding.btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    // Hapus data SharedPreferences (sesi login)
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()

                    // Kembali ke AuthActivity dan tutup MainActivity
                    val intent = Intent(this, AuthActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}