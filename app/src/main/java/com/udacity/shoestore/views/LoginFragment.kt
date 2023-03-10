package com.udacity.shoestore.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.viewmodels.OnBoardingViewModel

class LoginFragment: Fragment() {

    lateinit var binding: FragmentLoginBinding
    private val viewModel: OnBoardingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginBtn.setOnClickListener { login(false) }
        binding.registerBtn.setOnClickListener { login(true) }
    }

    private fun login(newLogin: Boolean) {
        val destination =
            if (newLogin) R.id.action_loginFragment_to_onBoardingFragment
            else R.id.action_loginFragment_to_shoeListingFragment

        if (newLogin) {
            // set the user
            viewModel.setUserName(binding.name.text.toString())
        }
        findNavController().navigate(destination)
    }
}