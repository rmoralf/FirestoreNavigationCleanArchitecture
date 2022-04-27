package com.rmoralf.firestorenavigationcleanarchitecture.presentation.recipes.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.navigation.Screen

@Composable
fun RecipesTopBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = Screen.RECIPES.resourceId)
            )
        }
    )
}