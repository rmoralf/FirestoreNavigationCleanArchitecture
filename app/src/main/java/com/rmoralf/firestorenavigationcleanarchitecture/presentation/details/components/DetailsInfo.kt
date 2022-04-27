package com.rmoralf.firestorenavigationcleanarchitecture.presentation.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rmoralf.firestorenavigationcleanarchitecture.R
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Recipe
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.samples.SampleRecipeProvider

@Preview(showBackground = true)
@Composable
fun DetailsInfo(
    @PreviewParameter(SampleRecipeProvider::class, 2)
    recipe: Recipe
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(12.dp)
    ) {
        recipe.name?.let {
            Text(
                text = it,
                color = Black,
                fontSize = 28.sp
            )
        }
        recipe.time?.let {
            Text(
                text = stringResource(id = R.string.recipe_time, it),
                color = Black,
                fontSize = 16.sp
            )
        }
        recipe.style?.let {
            Text(
                text = stringResource(id = R.string.recipe_style, it),
                color = Black,
                fontSize = 16.sp
            )
        }
    }
}