package com.udacity.shoestore.viewmodels

import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListingViewModel: ViewModel() {

    private val _shoes: MutableList<Shoe> by lazy {
        defaultShoeList.toMutableList()
    }
    val shoes: List<Shoe>
        get() = _shoes


    fun addNewShoe(shoe: Shoe) {
        _shoes.add(shoe)
    }

    companion object {

        private val defaultShoeList = listOf(
            Shoe(
                name = "Air Zoom Vapor Pro",
                size = 45.5,
                company = "Nike",
                description = "Air Zoom Vapor Pro carpet shoe men - White, Black",
                images = emptyList()
            ),
            Shoe(
                name = "Air Zoom Vapor",
                size = 45.0,
                company = "Nike",
                description = "Air Zoom Vapor all court tennis shoe men - Black, Dark Grey",
                images = emptyList()
            ),
            Shoe(
                name = "Court Jam",
                size = 38.5,
                company = "Adidas",
                description = "Court Jam all court tennis shoe women - White, Silver",
                images = emptyList()
            ),
            Shoe(
                name = "Barricade",
                size = 42.0,
                company = "Adidas",
                description = "Barricade All court shoe kids - Dark Blue, White",
                images = emptyList()
            ),
            Shoe(
                name = "Adizero Ubersonic",
                size = 43.0,
                company = "Adidas",
                description = "Adizero Ubersonic all court shoe women - White, Violet",
                images = emptyList()
            ),
            Shoe(
                name = "CourtJam",
                size = 40.0,
                company = "Adidas",
                description = "CourtJam Control carpet shoe women - White, Turquoise",
                images = emptyList()
            ),
            Shoe(
                name = "Zoom Vapor Cage 4 Pros",
                size = 42.0,
                company = "Nike",
                description = "Zoom Vapor Cage 4 Rafa all court shoe men - Black, Neon Green",
                images = emptyList()
            ),
            Shoe(
                name = "Zoom NXT",
                size = 39.5,
                company = "Nike",
                description = "Zoom NXT all court shoe women - Black, Ecru",
                images = emptyList()
            ),
            Shoe(
                name = "Court Vapor Lite",
                size = 44.5,
                company = "Nike",
                description = "Court Vapor Lite all court shoe men - Black, White",
                images = emptyList()
            ),
            Shoe(
                name = "Game Court 2",
                size = 44.5,
                company = "Adidas",
                description = "Game Court 2 all court shoe women - White, Silver",
                images = emptyList()
            ),
            Shoe(
                name = "Court Jam Control",
                size = 44.5,
                company = "Adidas",
                description = "Court Jam Control all court shoe women - Green, White",
                images = emptyList()
            ),
            Shoe(
                name = "Air Zoom Vapor Pro",
                size = 44.5,
                company = "Nike",
                description = "Air Zoom Vapor Pro clay court shoe women - Black, Gold",
                images = emptyList()
            ),
        )
    }
}