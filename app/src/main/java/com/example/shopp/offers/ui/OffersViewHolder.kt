package com.example.shopp.offers.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.shopp.R
import com.example.shopp.config.FeaturesManager
import com.example.shopp.databinding.ItemOffersBinding
import com.example.shopp.offers.data.Offer

class OffersViewHolder(private val binding: ItemOffersBinding, private val addToSLListener: (item: Offer) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Offer) {
        binding.productName.text = item.title
        binding.productDetails.text = item.detail
        binding.productPrice.text = item.price
        binding.productImage.setImageResource(item.imageId)
        binding.addToSlBtn.visibility = if (FeaturesManager.isShoppingListActive) View.VISIBLE else View.GONE
        binding.addToSlBtn.setOnClickListener {
            item.addedToShoppingList = !item.addedToShoppingList
            addToSLListener.invoke(item)
            updateCheckedState(item)
        }
        updateCheckedState(item)
    }

    private fun updateCheckedState(item: Offer) {
        val drawableId =
            if (item.addedToShoppingList) R.drawable.ic_remove_from_list else R.drawable.ic_add_to_list
        binding.addToSlBtn.setImageResource(drawableId)
    }
}