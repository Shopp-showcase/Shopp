package com.example.shopp

import android.app.Application
import com.example.shopp.offers.data.OffersRepository

class ShoppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        OffersRepository.initOffers(applicationContext)
    }
}