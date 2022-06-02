package com.example.shopp.offers.data

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import java.io.IOException

class OffersDataParser {

    companion object {

        fun parseOffersData(context: Context): OffersList? {
            try {
                val offersJson =
                    context.assets.open("offers.json").bufferedReader().use { it.readText() }
                return Gson().fromJson(offersJson, OffersList::class.java)
            } catch (e: IOException) {
                Log.e(OffersRepository::class.java.simpleName, "Error parsing offers")
                e.printStackTrace()
            }
            return null
        }
    }
}