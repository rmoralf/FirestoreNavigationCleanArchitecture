package com.rmoralf.firestorenavigationcleanarchitecture.presentation.recipes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rmoralf.firestorenavigationcleanarchitecture.core.utils.Utils.Companion.printError
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Response.*
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.components.ProgressBar
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.navigation.Screen
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.recipes.components.EmptyListText
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.recipes.components.RecipesListItem
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.recipes.components.RecipesTopBar

@Composable
fun RecipesScreen(
    navController: NavController,
    viewModel: RecipesViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            RecipesTopBar()
        }
    ) {
        when (val recipesResponse = viewModel.recipesState.value) {
            is Loading -> ProgressBar()
            is Success -> Box(
                modifier = Modifier.fillMaxSize()
            ) {
                val recipesList = recipesResponse.data
                if (recipesList.isNullOrEmpty()) {
                    EmptyListText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                } else {
                    LazyColumn {
                        itemsIndexed(recipesList) { index, item ->
                            RecipesListItem(
                                recipe = item
                            ) {
                                navController.navigate(
                                    "${Screen.DETAILS.route}/${item.id}"
                                )
                            }
                            if (index < recipesList.lastIndex)
                                Divider(color = White)
                        }
                    }
                }
            }
            is Error -> printError(recipesResponse.message)
        }

    }
}