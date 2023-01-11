package com.udacity.shoestore.models

import android.os.Parcelable
import android.widget.EditText
import androidx.databinding.InverseMethod
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
    val images: List<String> = mutableListOf()
): Parcelable {
    var sizeAsString = size.toString()
}