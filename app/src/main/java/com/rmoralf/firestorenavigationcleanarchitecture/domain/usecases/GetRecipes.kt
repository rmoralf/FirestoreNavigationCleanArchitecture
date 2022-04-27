package com.rmoralf.firestorenavigationcleanarchitecture.domain.usecases

import com.rmoralf.firestorenavigationcleanarchitecture.domain.repository.RecipesRepository

class GetRecipes(
    private val repository: RecipesRepository
) {
    operator fun invoke() = repository.getRecipes()
}