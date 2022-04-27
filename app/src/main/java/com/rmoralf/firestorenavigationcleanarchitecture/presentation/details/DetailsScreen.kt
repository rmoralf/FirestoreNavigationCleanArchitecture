package com.rmoralf.firestorenavigationcleanarchitecture.presentation.details

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rmoralf.firestorenavigationcleanarchitecture.R
import com.rmoralf.firestorenavigationcleanarchitecture.core.utils.Utils
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Response
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.navparams.IngredientsParams
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.components.ProgressBar
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.details.components.DetailsInfo
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.details.components.DetailsTopBar
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.navigation.Screen
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun DetailsScreen(
    navController: NavController,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            DetailsTopBar(navController)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            when (val detailsResponse = viewModel.state.value) {
                is Response.Loading -> ProgressBar()
                is Response.Success -> Column(
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    DetailsInfo(recipe = detailsResponse.data)
                    detailsResponse.data.ingredients?.let {
                        Button(onClick = {
                            val params = IngredientsParams(ingredients = it)
                            val ingredientsArgs = Uri.encode(Json.encodeToString(params))
                            navController.navigate(
                                "${Screen.INGREDIENTS.route}/${ingredientsArgs}"
                            )
                        }) {
                            Text(text = stringResource(id = R.string.see_ingredients))
                        }
                    }
                }
                is Response.Error -> Utils.printError(detailsResponse.message)
            }
        }
    }
}