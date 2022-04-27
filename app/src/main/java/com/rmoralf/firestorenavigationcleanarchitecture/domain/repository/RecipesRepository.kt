package com.rmoralf.firestorenavigationcleanarchitecture.domain.repository

import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Recipe
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Response
import kotlinx.coroutines.flow.Flow

interface RecipesRepository {

    fun getRecipes(): Flow<Response<List<Recipe>>>

    fun getRecipeDetails(recipeRef: String): Flow<Response<Recipe>>
}