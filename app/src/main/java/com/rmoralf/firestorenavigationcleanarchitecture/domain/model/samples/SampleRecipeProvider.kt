package com.rmoralf.firestorenavigationcleanarchitecture.domain.model.samples

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Ingredient
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Recipe

class SampleRecipeProvider : PreviewParameterProvider<Recipe> {
    override val values = sequenceOf(
        Recipe(
            name = "Chicken curry",
            style = "Indian",
            time = "50",
            ingredients = listOf(
                Ingredient(
                    item = "Chicken",
                    amount = "300",
                    unit = "gr"
                ),
                Ingredient(
                    item = "Curry",
                    amount = "4",
                    unit = "Tbsp"
                ),
                Ingredient(
                    item = "Onion",
                    amount = "1",
                    unit = "Medium"
                )
            )
        ),
        Recipe(
            name = "Guacamole",
            style = "Mexican",
            time = "10",
            ingredients = listOf(
                Ingredient(
                    item = "Avocado",
                    amount = "2",
                    unit = "Medium"
                ),
                Ingredient(
                    item = "Onion",
                    amount = "2",
                    unit = "Small"
                ),
                Ingredient(
                    item = "Chipotle",
                    amount = "2",
                    unit = "Tsp"
                ),
                Ingredient(
                    item = "Salt"
                ),
                Ingredient(
                    item = "Pepper"
                )
            )
        )
    )
}