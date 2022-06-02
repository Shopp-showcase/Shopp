package com.example.shopp.offers.data

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

object OffersRepository {

    private val _offerItemsFlow: MutableStateFlow<OffersList?> = MutableStateFlow(null)
    val offerItemsFlow: StateFlow<OffersList?> = _offerItemsFlow

    fun initOffers(context: Context) {
        CoroutineScope(Dispatchers.Default).launch {
           _offerItemsFlow.emit(OffersDataParser.parseOffersData(context))
        }
    }
}