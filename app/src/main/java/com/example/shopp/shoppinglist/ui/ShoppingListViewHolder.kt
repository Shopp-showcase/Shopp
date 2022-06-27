package com.example.shopp.shoppinglist.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.shopp.databinding.ItemShoppingListBinding
import com.example.shopp.shoppinglist.data.ShoppingListItem

class ShoppingListViewHolder(
    private val binding: ItemShoppingListBinding,
    private val checkSLItemListener: (item: ShoppingListItem, isChecked: Boolean) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ShoppingListItem) {
        binding.productName.text = item.productName
        binding.shoppingItemCheckBox.isChecked = item.checked
        binding.shoppingItemCheckBox.setOnCheckedChangeListener { _, isChecked ->
            checkSLItemListener.invoke(item, isChecked)
        }
    }
}
