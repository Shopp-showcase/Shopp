package com.example.shopp.offers.data

import com.example.shopp.R

class OffersImageProvider {

    companion object {
        fun getImageId(offerId: String): Int {
            return when (offerId) {
                "offer_001" -> R.drawable.offer_1
                "offer_002" -> R.drawable.offer_2
                "offer_003" -> R.drawable.offer_3
                "offer_004" -> R.drawable.offer_4
                "offer_005" -> R.drawable.offer_5
                "offer_006" -> R.drawable.offer_6
                "offer_007" -> R.drawable.offer_7
                else -> R.drawable.arrow_back
            }
        }
    }
}