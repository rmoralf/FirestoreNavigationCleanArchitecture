package com.rmoralf.firestorenavigationcleanarchitecture.presentation.ingredients.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rmoralf.firestorenavigationcleanarchitecture.R
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.ui.theme.HeaderBg

@Composable
fun IngredientsListHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(HeaderBg)
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.ingredients_item),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.weight(3f)
        )
        Text(
            text = stringResource(id = R.string.ingredients_amount),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = stringResource(id = R.string.ingredients_unit),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
    }

}