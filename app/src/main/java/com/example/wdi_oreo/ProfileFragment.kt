package com.example.wdi_oreo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wdi_oreo.databinding.FragmentProfileBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Klik tombol kapsul Beranda -> alihkan BottomNavigation ke tab Home
        binding.btnBackToHome.setOnClickListener {
            val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavView)
            bottomNav.selectedItemId = R.id.nav_home
        }
        // Event klik tombol Bagikan Info Aplikasi
        binding.btnShareApp.setOnClickListener {
            val shareText = """
        *WDI Oreo - SEMAWIT App*
        Aplikasi manajemen kebun dan hasil panen kelapa sawit KUD SEMAWIT.
        Dikembangkan oleh: Wulan Dari (Teknik Informatika).
    """.trimIndent()

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }

            // Memunculkan Android Share Sheet chooser
            startActivity(Intent.createChooser(intent, "Bagikan informasi via:"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}