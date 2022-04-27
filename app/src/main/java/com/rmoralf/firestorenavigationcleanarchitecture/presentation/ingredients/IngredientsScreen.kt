package com.rmoralf.firestorenavigationcleanarchitecture.presentation.ingredients

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rmoralf.firestorenavigationcleanarchitecture.core.utils.Utils.Companion.printError
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Response.*
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.components.ProgressBar
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.ingredients.components.IngredientsList
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.ingredients.components.IngredientsTopBar

@Composable
fun IngredientsScreen(
    navController: NavController,
    viewModel: IngredientsViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            IngredientsTopBar(navController)
        }
    ) {
        when (val ingredientsResponse = viewModel.state.value) {
            is Loading -> ProgressBar()
            is Success -> {
                IngredientsList(ingredientsResponse.data)
            }
            is Error -> printError(ingredientsResponse.message)
        }


    }
}