package com.example.shopp.shoppinglist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.shopp.databinding.FragmentShoppingListBinding
import kotlinx.coroutines.launch

class ShoppingListFragment : Fragment() {

    private val viewModel: ShoppingListViewModel by viewModels()
    private var binding: FragmentShoppingListBinding? = null

    private val adapter = ShoppingListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentShoppingListBinding.inflate(inflater, null, false).apply {
            shoppingListRecycler.adapter = adapter
        }

        lifecycleScope.launch {
            viewModel.shoppingListItemsStream.flowWithLifecycle(viewLifecycleOwner.lifecycle).collect {
                adapter.updateItems(it)
            }
        }

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }
}
