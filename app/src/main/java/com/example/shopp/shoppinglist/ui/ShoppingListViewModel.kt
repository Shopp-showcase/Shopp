package com.example.shopp.shoppinglist.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.shopp.offers.data.Offer
import com.example.shopp.shoppinglist.data.ShoppingListItem
import com.example.shopp.shoppinglist.data.ShoppingListRepository

class ShoppingListViewModel(app: Application) : AndroidViewModel(app) {

    val shoppingListItemsStream = ShoppingListRepository.shoppingListItemsFlow

    fun addShoppingListItem(offer: Offer) {
        val slItem = ShoppingListItem(offer.id, offer.title)
        if (offer.addedToShoppingList) {
            ShoppingListRepository.addShoppingListItem(slItem)
        } else {
            ShoppingListRepository.removeShoppingListItem(slItem)
        }
    }

    fun checkShoppingListItem(shoppingListItem: ShoppingListItem, checked: Boolean) {
        if (checked) {
            ShoppingListRepository.checkShoppingListItem(shoppingListItem)
        } else {
            ShoppingListRepository.unCheckShoppingListItem(shoppingListItem)
        }
    }
}
