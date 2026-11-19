package com.example.wdi_oreo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wdi_oreo.databinding.ItemInfoSawitBinding

class InfoSawitAdapter(
    private val listInfo: List<InfoSawitModel>,
    private val onItemClick: (InfoSawitModel) -> Unit
) : RecyclerView.Adapter<InfoSawitAdapter.InfoViewHolder>() {

    inner class InfoViewHolder(val binding: ItemInfoSawitBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val binding = ItemInfoSawitBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return InfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        val item = listInfo[position]
        with(holder.binding) {
            tvJudulInfo.text = item.judul
            tvNilaiInfo.text = item.nilai
            Glide.with(holder.itemView.context)
                .load(item.imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(ivInfoSawit)

            root.setOnClickListener { onItemClick(item) }
        }
    }

    override fun getItemCount(): Int = listInfo.size
}