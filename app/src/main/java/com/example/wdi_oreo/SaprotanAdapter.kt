package com.example.wdi_oreo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.wdi_oreo.databinding.ItemSaprotanBinding
import com.google.android.material.snackbar.Snackbar

class SaprotanAdapter(
    context: Context,
    private val items: List<SaprotanModel>
) : ArrayAdapter<SaprotanModel>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemSaprotanBinding.inflate(LayoutInflater.from(context), parent, false)
        val data = items[position]

        binding.tvNamaSaprotan.text = data.namaProduk
        binding.tvHargaSaprotan.text = data.deskripsiHarga

        Glide.with(context)
            .load(data.imageUrl)
            .placeholder(R.mipmap.ic_launcher)
            .into(binding.ivSaprotan)

        binding.root.setOnClickListener {
            Snackbar.make(
                parent,
                "${data.namaProduk} — ${data.deskripsiHarga}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        return binding.root
    }
}