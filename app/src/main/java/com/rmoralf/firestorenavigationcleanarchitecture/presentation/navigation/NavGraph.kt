package com.rmoralf.firestorenavigationcleanarchitecture.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.rmoralf.firestorenavigationcleanarchitecture.core.utils.Constants.INGREDIENTS
import com.rmoralf.firestorenavigationcleanarchitecture.core.utils.Constants.RECIPE_REF
import com.rmoralf.firestorenavigationcleanarchitecture.core.utils.Utils.Companion.createSubroute
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.navparams.IngredientsParams
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.details.DetailsScreen
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.ingredients.IngredientsScreen
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.navigation.paramtypes.IngredientsParamsType
import com.rmoralf.firestorenavigationcleanarchitecture.presentation.recipes.RecipesScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.RECIPES.route
    ) {
        composable(route = Screen.RECIPES.route) {
            RecipesScreen(navController = navController)
        }

        composable(
            route = createSubroute(Screen.DETAILS.route, RECIPE_REF)
        ) {
            DetailsScreen(navController = navController)
        }
        composable(
            route = createSubroute(Screen.INGREDIENTS.route, INGREDIENTS),
            arguments = listOf(
                navArgument(INGREDIENTS) {
                    type = IngredientsParamsType()
                    defaultValue = IngredientsParams(emptyList())
                }
            )
        ) {
            IngredientsScreen(navController = navController)
        }
    }
}