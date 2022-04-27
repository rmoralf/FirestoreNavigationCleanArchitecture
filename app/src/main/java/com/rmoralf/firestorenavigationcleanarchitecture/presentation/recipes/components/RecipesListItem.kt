package com.rmoralf.firestorenavigationcleanarchitecture.presentation.recipes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Recipe
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.ui.theme.HeaderBg

@Composable
fun RecipesListItem(
    recipe: Recipe,
    navEvent: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(HeaderBg)
            .padding(20.dp)
            .clickable {
                navEvent()
            }
    ) {
        recipe.name?.let {
            Text(
                text = it,
                color = Black,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}