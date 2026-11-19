package com.example.wdi_oreo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wdi_oreo.databinding.FragmentProfileBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val listInfoSawit = listOf(
        InfoSawitModel("Harga TBS Minggu Ini", "Rp 3.180 / kg", "https://picsum.photos/id/10/400/300.jpg"),
        InfoSawitModel("Tabungan Perawatan", "Rp 2.450.000", "https://picsum.photos/id/160/400/300.jpg"),
        InfoSawitModel("Total Panen Bulan Ini", "4.820 kg TBS", "https://picsum.photos/id/28/400/300.jpg"),
        InfoSawitModel("Luas Lahan Terdaftar", "2,5 Hektar (Blok A)", "https://picsum.photos/id/15/400/300.jpg"),
        InfoSawitModel("Jadwal Pemupukan", "NPK • 25 Nov 2026", "https://picsum.photos/id/119/400/300.jpg"),
        InfoSawitModel("Mutu Sortasi PKS", "Grade A (96%)", "https://picsum.photos/id/180/400/300.jpg")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = InfoSawitAdapter(listInfoSawit) { item ->
            Toast.makeText(requireContext(), "${item.judul}: ${item.nilai}", Toast.LENGTH_SHORT).show()
        }

        binding.rvInfoSawit.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            this.adapter = adapter
        }

        binding.btnBackToHome.setOnClickListener {
            val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavView)
            bottomNav.selectedItemId = R.id.nav_home
        }

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
            startActivity(Intent.createChooser(intent, "Bagikan informasi via:"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}