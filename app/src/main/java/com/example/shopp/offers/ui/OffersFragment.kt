package com.example.shopp.offers.ui

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shopp.R
import com.example.shopp.config.FeaturesManager
import com.example.shopp.databinding.FragmentOffersBinding
import kotlinx.coroutines.launch

class OffersFragment : Fragment() {

    private val viewModel: OffersViewModel = OffersViewModel()
    private var binding: FragmentOffersBinding? = null
    private val adapter: OffersAdapter = OffersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentOffersBinding.inflate(inflater, null, false).apply {
            offersRecyclerView.adapter = adapter
            offersRecyclerView.layoutManager = GridLayoutManager(context, 2)
        }

        lifecycleScope.launch {
            viewModel.offersStream.flowWithLifecycle(viewLifecycleOwner.lifecycle).collect {
                if (it != null) {
                    adapter.updateItems(it)
                }
            }
        }

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpMenu()
    }

    private fun setUpMenu() {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.offers_menu, menu)
            }

            override fun onPrepareMenu(menu: Menu) {
                menu.findItem(R.id.menu_item_sl).isVisible = FeaturesManager.isShoppingListActive
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.menu_item_sl -> {
                        findNavController().navigate(R.id.action_offersFragment_to_shoppingListFragment)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }
}