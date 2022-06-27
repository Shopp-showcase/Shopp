package com.example.shopp.shoppinglist.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

object ShoppingListRepository {

    private val shoppingListItems = ArrayList<ShoppingListItem>()

    private val _shoppingListItemsFlow: MutableStateFlow<List<ShoppingListItem>> = MutableStateFlow(listOf())
    val shoppingListItemsFlow: StateFlow<List<ShoppingListItem>> = _shoppingListItemsFlow


    fun addShoppingListItem(shoppingListItem: ShoppingListItem) {
        shoppingListItems.add(shoppingListItem)
        postItemsUpdate()
    }

    fun removeShoppingListItem(shoppingListItem: ShoppingListItem) {
        shoppingListItems.removeIf { it.id == shoppingListItem.id }
        postItemsUpdate()
    }

    fun checkShoppingListItem(shoppingListItem: ShoppingListItem) {
        shoppingListItems.find { it.id == shoppingListItem.id }?.checked = true
        postItemsUpdate()
    }

    fun unCheckShoppingListItem(shoppingListItem: ShoppingListItem) {
        shoppingListItems.find { it.id == shoppingListItem.id }?.checked = false
        postItemsUpdate()
    }

    private fun postItemsUpdate() {
        CoroutineScope(Dispatchers.IO).launch {
            _shoppingListItemsFlow.emit(ArrayList(shoppingListItems))
        }
    }
}
