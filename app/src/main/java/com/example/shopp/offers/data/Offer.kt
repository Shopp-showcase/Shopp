package com.example.shopp.offers.data

data class Offer(val id: String, val title: String, val detail: String, val price: String, var imageId: Int, var addedToShoppingList: Boolean = false)
