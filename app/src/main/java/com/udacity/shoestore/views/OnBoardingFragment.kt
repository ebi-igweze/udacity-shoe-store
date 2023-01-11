package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentOnBoardingBinding
import com.udacity.shoestore.viewmodels.OnBoardingViewModel

class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding
    // create shared viewModel for on boarding screens
    private val viewModel: OnBoardingViewModel by activityViewModels()
    private var showingInstructions = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_on_boarding, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // show instructions fragment
        viewModel.shouldShowInstructions.observe(viewLifecycleOwner) { show ->
            if (!showingInstructions == show) {
                binding.instructionsFragment.visibility = View.VISIBLE
                binding.welcomeFragment.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // hide instructions screen when navigating away
        viewModel.hideInstructions()
    }
}