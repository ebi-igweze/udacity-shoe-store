package com.udacity.shoestore.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentOnBoardingWelcomeBinding
import com.udacity.shoestore.viewmodels.OnBoardingViewModel

private const val USER_NAME = "user_name"

/**
 * A simple [Fragment] subclass.
 * Use the [OnBoardingWelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnBoardingWelcomeFragment: Fragment() {

    private lateinit var binding: FragmentOnBoardingWelcomeBinding
    // get shared view model for onBoarding screens
    private val viewModel: OnBoardingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_on_boarding_welcome, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userName = "Ebi"
        binding.welcomeTitle.text = getString(R.string.welcomeTitle, userName)
        // show the instructions page
        binding.nextButton.setOnClickListener { viewModel.showInstructions() }
    }


    companion object {

        @JvmStatic
        fun newInstance() = OnBoardingWelcomeFragment()
    }
}