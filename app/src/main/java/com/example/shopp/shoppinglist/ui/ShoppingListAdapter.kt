package com.example.shopp.shoppinglist.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopp.databinding.ItemShoppingListBinding
import com.example.shopp.shoppinglist.data.ShoppingListItem

class ShoppingListAdapter(private val checkSLItemListener: (item: ShoppingListItem, isChecked: Boolean) -> Unit) : RecyclerView.Adapter<ShoppingListViewHolder>() {

    private val adapterItems = ArrayList<ShoppingListItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(items: List<ShoppingListItem>) {
        adapterItems.clear()
        adapterItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListViewHolder {
        val binding = ItemShoppingListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingListViewHolder(binding, checkSLItemListener)
    }

    override fun onBindViewHolder(holder: ShoppingListViewHolder, position: Int) {
        holder.bind(adapterItems[position])
    }

    override fun getItemCount() = adapterItems.count()
}
