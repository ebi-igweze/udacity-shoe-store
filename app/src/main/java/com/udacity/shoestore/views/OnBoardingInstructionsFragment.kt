package com.udacity.shoestore.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentOnBoardingInstructionsBinding
import com.udacity.shoestore.databinding.FragmentOnBoardingWelcomeBinding
import com.udacity.shoestore.viewmodels.OnBoardingViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [OnBoardingInstructionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnBoardingInstructionsFragment: Fragment() {

    private lateinit var binding: FragmentOnBoardingInstructionsBinding
    // get shared view model for onBoarding screens
    private val viewModel: OnBoardingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_on_boarding_instructions, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        binding.nextButton.setOnClickListener {
            navController.navigate(R.id.action_onBoardingFragment_to_shoeListingFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = OnBoardingInstructionsFragment()
    }
}