package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnBoardingViewModel: ViewModel() {

    private val _shouldShowInstructions = MutableLiveData<Boolean>()
    val shouldShowInstructions: LiveData<Boolean>
        get() = _shouldShowInstructions



    fun showInstructions() {
        _shouldShowInstructions.value = true
    }

}