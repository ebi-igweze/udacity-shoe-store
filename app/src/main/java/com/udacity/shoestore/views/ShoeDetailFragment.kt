package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeListingViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeListingViewModel by activityViewModels()
    private val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.shoe = Shoe(name = "", size = 0.0, company = "", description = "")
        binding.saveBtn.setOnClickListener { saveNewShoe() }
        binding.cancelBtn.setOnClickListener { navController.navigateUp() }
    }

    private fun saveNewShoe() {
        binding.shoe?.let { shoe ->
            // set the size as double value
            shoe.size = shoe.sizeAsString.toDoubleOrNull() ?: 0.0
            // add the shoe to list
            viewModel.addNewShoe(shoe)
            // navigate back
            navController.navigateUp()
        }
    }

}