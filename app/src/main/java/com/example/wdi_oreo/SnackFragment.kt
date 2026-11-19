package com.example.wdi_oreo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wdi_oreo.databinding.FragmentSnackBinding

class SnackFragment : Fragment() {

    private var _binding: FragmentSnackBinding? = null
    private val binding get() = _binding!!

    private val listSaprotan = listOf(
        SaprotanModel("Pupuk NPK Mutiara 50kg", "Rp 850.000 • Tersedia di Gudang KUD", "https://picsum.photos/id/10/400/300.jpg"),
        SaprotanModel("Pupuk Dolomit Super 50kg", "Rp 125.000 • Penetral pH Tanah Gambut", "https://picsum.photos/id/15/400/300.jpg"),
        SaprotanModel("Pupuk Urea Subsidi 50kg", "Rp 340.000 • Khusus Anggota KOPSA", "https://picsum.photos/id/28/400/300.jpg"),
        SaprotanModel("Pupuk KCL Mahkota 50kg", "Rp 780.000 • Penguat Bobot Janjang", "https://picsum.photos/id/119/400/300.jpg"),
        SaprotanModel("Egrek Sawit Malaysia Pro", "Rp 420.000 • Baja Karbon Tajam", "https://picsum.photos/id/160/400/300.jpg"),
        SaprotanModel("Dodos Panen Baja Per", "Rp 185.000 • Lebar Mata 12 cm", "https://picsum.photos/id/180/400/300.jpg"),
        SaprotanModel("Herbisida Roundup 4 Liter", "Rp 390.000 • Pengendali Gulma Piringan", "https://picsum.photos/id/20/400/300.jpg"),
        SaprotanModel("Galah Fiber 12 Meter", "Rp 650.000 • Ringan & Anti Karat", "https://picsum.photos/id/24/400/300.jpg")
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSnackBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lvSaprotan.adapter = SaprotanAdapter(requireContext(), listSaprotan)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}