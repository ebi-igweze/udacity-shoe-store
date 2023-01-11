package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnBoardingViewModel: ViewModel() {

    private val _shouldShowInstructions = MutableLiveData<Boolean>()
    val shouldShowInstructions: LiveData<Boolean>
        get() = _shouldShowInstructions

    private var _userName: String = ""
    val userName get() = _userName

    fun showInstructions() {
        _shouldShowInstructions.value = true
    }
    fun hideInstructions() {
        _shouldShowInstructions.value = false
    }

    fun setUserName(name: String) {
        _userName = name
    }
}