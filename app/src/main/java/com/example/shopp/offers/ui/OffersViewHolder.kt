package com.example.shopp.offers.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.shopp.databinding.ItemOffersBinding
import com.example.shopp.offers.data.Offer

class OffersViewHolder(private val binding: ItemOffersBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Offer) {
        binding.productName.text = item.title
        binding.productPrice.text = item.price
    }
}