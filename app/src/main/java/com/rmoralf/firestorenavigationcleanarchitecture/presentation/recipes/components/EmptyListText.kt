package com.rmoralf.firestorenavigationcleanarchitecture.presentation.recipes.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.rmoralf.firestorenavigationcleanarchitecture.R

@Composable
fun EmptyListText(modifier: Modifier) {
    Text(
        text = stringResource(id = R.string.no_recipes),
        color = Black,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}