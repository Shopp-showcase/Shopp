package com.example.shopp.offers.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shopp.R
import com.example.shopp.databinding.FragmentOffersBinding

class OffersFragment : Fragment() {

    private var binding: FragmentOffersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentOffersBinding.inflate(inflater, null, false).apply {
            shoppText.setOnClickListener {
                findNavController().navigate(R.id.action_offersFragment_to_shoppingListFragment)
            }
        }

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }
}