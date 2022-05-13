package com.example.shopp.shoppinglist.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.shopp.shoppinglist.data.ShoppingListItem
import com.example.shopp.shoppinglist.data.ShoppingListRepository

class ShoppingListViewModel(app: Application) : AndroidViewModel(app) {

    val shoppingListItemsStream = ShoppingListRepository.shoppingListItemsFlow

    fun addShoppingListItem(shoppingListItem: ShoppingListItem) {
        ShoppingListRepository.addShoppingListItem(shoppingListItem)
    }

    fun checkShoppingListItem(shoppingListItem: ShoppingListItem) {
        ShoppingListRepository.checkShoppingListItem(shoppingListItem)
    }

    fun unCheckShoppingListItem(shoppingListItem: ShoppingListItem) {
        ShoppingListRepository.unCheckShoppingListItem(shoppingListItem)
    }
}
