package com.rmoralf.firestorenavigationcleanarchitecture.presentation.navigation

import androidx.annotation.StringRes
import com.rmoralf.firestorenavigationcleanarchitecture.R

enum class Screen(val route: String, @StringRes val resourceId: Int) {
    RECIPES("splash", R.string.screen_recipes),
    DETAILS("details", R.string.screen_details),
    INGREDIENTS("providers", R.string.screen_ingredients),
}