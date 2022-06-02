package com.example.shopp.offers.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopp.databinding.ItemOffersBinding
import com.example.shopp.offers.data.Offer
import com.example.shopp.offers.data.OffersList

class OffersAdapter : RecyclerView.Adapter<OffersViewHolder>() {

    private val adapterItems = ArrayList<Offer>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(list: OffersList) {
        adapterItems.clear()
        adapterItems.addAll(list.offers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersViewHolder {
        val binding = ItemOffersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OffersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) {
        holder.bind(adapterItems[position])
    }

    override fun getItemCount(): Int = adapterItems.size

}
