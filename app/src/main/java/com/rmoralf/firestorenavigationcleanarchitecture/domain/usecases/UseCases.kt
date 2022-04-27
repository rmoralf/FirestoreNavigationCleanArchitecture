package com.rmoralf.firestorenavigationcleanarchitecture.domain.usecases

data class UseCases(
    //Firestore
    val getRecipes: GetRecipes,
    val getRecipeDetails: GetRecipeDetails
)
