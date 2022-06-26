package com.example.shopp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shopp.config.RemoteConfigManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RemoteConfigManager().fetchRemoteConfig()
    }
}