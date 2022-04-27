package com.rmoralf.firestorenavigationcleanarchitecture.presentation.ingredients.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Ingredient
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.ui.theme.DividerBg

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IngredientsList(ingredientsList: List<Ingredient>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        stickyHeader {
            IngredientsListHeader()
        }
        itemsIndexed(ingredientsList) { index, item ->
            IngredientsListItem(ingredient = item)
            if (index < ingredientsList.lastIndex)
                Divider(color = DividerBg)
        }
    }

}