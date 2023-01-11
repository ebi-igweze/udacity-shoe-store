package com.udacity.shoestore.views

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuProvider
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.databinding.ListItemShoeBinding
import com.udacity.shoestore.viewmodels.ShoeListingViewModel

class ShoeListingFragment : Fragment(), NestedScrollView.OnScrollChangeListener {

    private lateinit var binding: FragmentShoeListingBinding
    private val viewModel: ShoeListingViewModel by activityViewModels()
    private val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_listing, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // listen for scroll events
        binding.scrollView.setOnScrollChangeListener(this)
        // navigate to shoe details fragment
        binding.fab.setOnClickListener {
            navController.navigate(R.id.action_shoeListingFragment_to_shoeDetailFragment)
        }

        // add menu options
        addMenuOptions()
        // add shoe items to view
        addShoesItemViews()
    }

    private fun addShoesItemViews() {
        val inflater = LayoutInflater.from(requireContext())
        viewModel.shoes.forEach { shoe ->
            // inflate shoe list item view
            val shoeListItem: ListItemShoeBinding = DataBindingUtil.inflate(
                inflater, R.layout.list_item_shoe, null, false)
            // set the shoe variable binding
            shoeListItem.shoe = shoe
            // add the list item to layout
            binding.shoeListingContainer.addView(shoeListItem.root)
        }
    }

    private fun addMenuOptions() {
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.main_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == R.id.logout) {
                    navController.navigate(R.id.action_shoeListingFragment_to_loginFragment)
                    return true
                } else {
                   return false
                }
            }

        }, viewLifecycleOwner)
    }


    override fun onScrollChange(
        v: NestedScrollView,
        scrollX: Int,
        scrollY: Int,
        oldScrollX: Int,
        oldScrollY: Int
    ) {

        with(binding) {
            // the delay of the extension of the FAB is set for 12 items
            if (scrollY > oldScrollY + 12 && fab.isExtended) {
                fab.shrink()
            }

            // the delay of the extension of the FAB is set for 12 items
            if (scrollY < oldScrollY - 12 && !fab.isExtended) {
                fab.extend()
            }

            // if the nestedScrollView is at the first item of the list then the
            // extended floating action should be in extended state
            if (scrollY == 0) {
                fab.extend()
            }

        }
    }

}