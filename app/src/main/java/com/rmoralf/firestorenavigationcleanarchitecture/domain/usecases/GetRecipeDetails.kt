package com.rmoralf.firestorenavigationcleanarchitecture.domain.usecases

import com.rmoralf.firestorenavigationcleanarchitecture.domain.repository.RecipesRepository

class GetRecipeDetails(
    private val repository: RecipesRepository
) {
    operator fun invoke(recipeRef: String) = repository.getRecipeDetails(recipeRef)
}