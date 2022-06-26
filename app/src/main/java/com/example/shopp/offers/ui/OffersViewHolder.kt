package com.example.shopp.offers.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.shopp.config.FeaturesManager
import com.example.shopp.databinding.ItemOffersBinding
import com.example.shopp.offers.data.Offer

class OffersViewHolder(private val binding: ItemOffersBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Offer) {
        binding.productName.text = item.title
        binding.productDetails.text = item.detail
        binding.productPrice.text = item.price
        binding.productImage.setImageResource(item.imageId)
        binding.addToSlBtn.visibility = if (FeaturesManager.isShoppingListActive) View.VISIBLE else View.GONE
    }
}