package com.example.shopp.offers.ui

import com.example.shopp.offers.data.OffersRepository

class OffersViewModel {

    val offersStream = OffersRepository.offerItemsFlow
}