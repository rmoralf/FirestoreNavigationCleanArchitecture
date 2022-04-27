package com.rmoralf.firestorenavigationcleanarchitecture.data.repository

import com.google.firebase.firestore.CollectionReference
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Recipe
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Response.Error
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Response.Success
import com.rmoralf.firestorenavigationcleanarchitecture.domain.repository.RecipesRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

class RecipesRepositoryImpl(
    private val recipesRef: CollectionReference
) : RecipesRepository {
    override fun getRecipes() = callbackFlow {
        val snapshotListener = recipesRef.addSnapshotListener { snapshot, e ->
            val response = if (snapshot != null) {
                val recipes = snapshot.toObjects(Recipe::class.java)
                Success(recipes)
            } else {
                Error(e?.message ?: e.toString())
            }
            trySend(response).isSuccess
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override fun getRecipeDetails(recipeRef: String) = callbackFlow {
        val snapshotListener = recipesRef.document(recipeRef).addSnapshotListener { snapshot, e ->
            val response = if (snapshot != null) {
                val recipe = snapshot.toObject(Recipe::class.java)!!
                Success(recipe)
            } else {
                Error(e?.message ?: e.toString())
            }
            trySend(response).isSuccess
        }
        awaitClose {
            snapshotListener.remove()
        }

    }
}