package com.example.wdi_oreo

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.wdi_oreo.databinding.FragmentHomeBinding
import java.util.Calendar

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKUDWeb.setOnClickListener {
            val intent = Intent(requireContext(), WebActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->
                    val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                    sharedPref.edit().clear().apply()

                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Batal", null)
                .show()
        }

        binding.cardDatePicker.setOnClickListener {
            // 1. Ambil tanggal, bulan, dan tahun saat ini secara otomatis
            val calendar = Calendar.getInstance()
            val tahunIni = calendar.get(Calendar.YEAR)
            val bulanIni = calendar.get(Calendar.MONTH)
            val hariIni = calendar.get(Calendar.DAY_OF_MONTH)

            // 2. Tampilkan dialog kalender bawaan Android
            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { _, year, month, dayOfMonth ->
                    // month bernilai 0 - 11, tambahkan 1
                    val formatTanggal = "$dayOfMonth/${month + 1}/$year"

                    binding.tvTanggalTerpilih.text = "Tanggal: $formatTanggal"
                    binding.tvAgendaKebun.text =
                        "Jadwal Terjadwal: Rotasi Panen & Cek Timbangan TBS"
                },
                tahunIni,
                bulanIni,
                hariIni
            )

            datePickerDialog.show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}