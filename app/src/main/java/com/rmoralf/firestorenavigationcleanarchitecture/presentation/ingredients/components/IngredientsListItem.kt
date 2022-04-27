package com.rmoralf.firestorenavigationcleanarchitecture.presentation.ingredients.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Ingredient

@Composable
fun IngredientsListItem(
    ingredient: Ingredient
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Text(
            text = ingredient.item ?: "",
            modifier = Modifier.weight(3f)
        )
        Text(
            text = ingredient.amount ?: "",
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = ingredient.unit ?: "",
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
    }

}
