package com.rmoralf.firestorenavigationcleanarchitecture.domain.model

data class Recipe(
    var id: String? = null,
    var name: String? = null,
    var time: String? = null,
    var style: String? = null,
    var ingredients: List<Ingredient>? = null
)