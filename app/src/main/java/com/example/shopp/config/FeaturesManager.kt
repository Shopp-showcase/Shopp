package com.example.shopp.config

import com.google.firebase.remoteconfig.FirebaseRemoteConfig

object FeaturesManager {

    val isShoppingListActive = FirebaseRemoteConfig.getInstance().getBoolean("shopping_list")
}